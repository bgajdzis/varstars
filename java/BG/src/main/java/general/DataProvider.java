/**
 * Created by gajdzis on 6/7/17.
 */
package general;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;
import pl.ls.objects.compound.base.IReferenceObject;

import javax.persistence.Column;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map.Entry;
import java.util.AbstractMap;

public class DataProvider {

    private List<String> resultsMap = new ArrayList();
    private Set<IReferenceObject> refSet = null;
    private List<VarstarsIG> igList = null;
    private Connection conn = null;
    private String connstring;
    private String user;
    private String pass;

    private DataProvider() {
        //set connection string
        Properties prop = new Properties();
        InputStream input = null;

        try {

            input = new FileInputStream("target/classes/config.properties");

            // load a properties file
            prop.load(input);

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        this.connstring = prop.getProperty("databaseUrl");
        this.user = prop.getProperty("databaseUser");
        this.pass = prop.getProperty("databasePassword");
        System.out.println("Connecting to " + connstring);
        // Create Reference Object set
        this.refSet = new HashSet<IReferenceObject>();
        try {
            this.conn = DriverManager.getConnection(this.connstring, this.user, this.pass);
        } catch (Exception e) {
            System.out.println("Connection failed");
            e.printStackTrace();
        }
        try {
            Statement refGet = this.conn.createStatement();
            ResultSet refResults = refGet.executeQuery(Constants.SQLreferenceSelect); //TODO: fix hardcoded queries
            VarstarsRef refobj = null;
            String type = null;
            VarstarFeatureSet featureSet = null;
            Field[] fields = VarstarFeatureSet.class.getDeclaredFields();
            ObjectMapper om = new ObjectMapper();
            while (refResults.next()) {
                featureSet = new VarstarFeatureSet();
                type = refResults.getString("type");
                BeanUtils.setProperty(featureSet, "timeseriesObs", om.readValue(refResults.getString("timeseries"), new TypeReference<Map<Double, Double>>() {
                }));
                for (int i = 0; i < fields.length; i++) {
                    if (fields[i].getType() == Double.class) {
                        try {
                            Optional<Double> val = Optional.of((Double) refResults.getDouble(fields[i].getAnnotation(Column.class).name()));
                            BeanUtils.setProperty(featureSet, fields[i].getName(), val.orElse(0.0));
                        } catch (Error e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                }
                refobj = new VarstarsRef(featureSet, type);
                try {
                    this.refSet.add(refobj);
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            refResults.close();
            refGet.close();
        } catch (Exception e) {
            System.out.println("Can't get results - Ref");
            e.printStackTrace();
        }
        System.out.println("refset complete");
        // Create InputGranule set
        this.igList = new ArrayList<VarstarsIG>();
        try {
            Statement igGet = this.conn.createStatement();
            ResultSet igResults = igGet.executeQuery(Constants.SQLinputGranuleSelect);
            VarstarsIG igobj = null;
            String name = null;
            VarstarFeatureSet featureSet = null;
            Field[] fields = VarstarFeatureSet.class.getDeclaredFields();
            ObjectMapper om = new ObjectMapper();
            while (igResults.next()) {
                featureSet = new VarstarFeatureSet();
                name = igResults.getString("object_id");
                BeanUtils.setProperty(featureSet, "timeseriesObs", om.readValue(igResults.getString("timeseries"), new TypeReference<Map<Double, Double>>() {
                }));
                for (int i = 0; i < fields.length; i++) {
                    if (fields[i].getType() == Double.class) {
                        try {
                            Optional<Double> val = Optional.of((Double) igResults.getDouble(fields[i].getAnnotation(Column.class).name()));
                            BeanUtils.setProperty(featureSet, fields[i].getName(), val.orElse(0.0));
                        } catch (Error e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                }
                igobj = new VarstarsIG(featureSet, name);
                try {
                    this.igList.add(igobj);
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            igResults.close();
            igGet.close();
        } catch (Exception e) {
            System.out.println("Can't get results - IG");
            e.printStackTrace();
        }
        System.out.println("ig list complete");
    }

    public static DataProvider getInstance() {
        return DataProviderHolder.INSTANCE;
    }

    public Set<IReferenceObject> getRefSet() {
        return this.refSet;
    }

    public List<VarstarsIG> getIgList() {
        return this.igList;
    }

    public void saveResult(String formattedResult) {
        this.resultsMap.add(formattedResult);
    }

    public void commitResult(List<String> resultmap) {
        try {
            Statement commitStatement = this.conn.createStatement();
            String query = Constants.SQLresultInsertHeader;
            for (String entry : resultmap) {
                query += "\n(" + entry + "),";
            }
            query = query.substring(0, query.length() - 1);
            System.out.println(query);
            commitStatement.executeUpdate(query);
            commitStatement.close();
        } catch (Exception e) {
            System.out.println(String.format("Result insertion failed"));
            e.printStackTrace();
        }
    }

    public void commitResult() {
        if (this.resultsMap.size() != 0) {
            commitResult(this.resultsMap);
            this.resultsMap = new ArrayList<>();
        }
    }

    public Double getF1Score(String runId){
        try {
            Statement requestF1Statement = this.conn.createStatement();
            ResultSet f1Result = requestF1Statement.executeQuery(Constants.SQLf1Getter + runId);
            f1Result.next();
            Double f1 = f1Result.getDouble("f1_score");
            requestF1Statement.close();
            return f1;
        } catch (Exception e) {
            System.out.println("F1 Score not retrieved due to the following problem");
            e.printStackTrace();
            return 0.0;
        }
    }

    private static class DataProviderHolder {
        private static final DataProvider INSTANCE = new DataProvider();
    }
}

