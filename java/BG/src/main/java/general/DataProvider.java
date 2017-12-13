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

    private List<Map.Entry<String,String>> resultsMap = new ArrayList();
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
            ResultSet refResults = refGet.executeQuery("SELECT * FROM reference_timeseries"); //TODO: fix hardcoded queries
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
            ResultSet igResults = igGet.executeQuery("SELECT * FROM input_timeseries");
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

    public void saveResult(String name, String type) {
        this.resultsMap.add(new AbstractMap.SimpleImmutableEntry<>(name, type));
    }

    public void commitResult(List<Entry<String,String>> resultmap) {
        try {
            Statement commitStatement = this.conn.createStatement();
            String query = "INSERT into predicted_types (name, type) VALUES \n";
            for (Map.Entry<String, String> entry : resultmap) {
                query += String.format("('%s','%s'),\n", entry.getKey(), entry.getValue());
            }
            query = query.substring(0, query.length() - 2);
            System.out.println(query);
            commitStatement.executeQuery(query);
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

    private static class DataProviderHolder {
        private static final DataProvider INSTANCE = new DataProvider();
    }
}

