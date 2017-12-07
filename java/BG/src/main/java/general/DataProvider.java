/**
 * Created by gajdzis on 6/7/17.
 */
package general;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.type.TypeReference;
import javax.persistence.Column;
import org.json.JSONObject;

import pl.ls.objects.compound.base.IReferenceObject;

import java.lang.reflect.Field;
import java.sql.*;
import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.commons.beanutils.BeanUtils;

import general.VarstarsRef;
import general.VarstarsIG;
import general.VarstarFeatureSet;

public class DataProvider {

    public static DataProvider getInstance() {
        return DataProviderHolder.INSTANCE;
    }

    public Set<IReferenceObject> getRefSet() {
        return this.refSet;
    }
    public List<VarstarsIG> getIgList() {return this.igList; }

    private Map<String,String> resultsMap = new ConcurrentHashMap();
    public void saveResult(String name, String type){
        this.resultsMap.put(name,type);
    }
    public void commitResult(Map<String,String> resultmap){
        try {
            Statement commitStatement = this.conn.createStatement();
            String query = "INSERT into predicted_types (name, type) VALUES \n";
            for (Map.Entry<String, String> entry : resultmap.entrySet()) {
                query+=String.format("('%s','%s'),\n", entry.getKey(), entry.getValue());
            }
            query=query.substring(0, query.length() - 2);
            System.out.println(query);
            commitStatement.executeQuery(query);
            commitStatement.close();
        } catch (Exception e) {
            System.out.println(String.format("Result insertion failed"));
            e.printStackTrace();
        }
    }
    public void commitResult(){
        commitResult(this.resultsMap);
        this.resultsMap = new ConcurrentHashMap<>();
    }

    private Set<IReferenceObject> refSet = null;
    private List<VarstarsIG> igList = null;

    private Connection conn = null;
    private String connstring;
    private String user;
    private String pass;
    private static class DataProviderHolder {
        private static final DataProvider INSTANCE = new DataProvider();
    }
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
        System.out.println("Connecting to "+connstring);
        // Create Reference Object set
        this.refSet = new HashSet<IReferenceObject>();
        try {
            this.conn = DriverManager.getConnection(this.connstring,this.user,this.pass);
        } catch (Exception e) {
            System.out.println("Connection failed");
            e.printStackTrace();
        }
        try {
            Statement refGet = this.conn.createStatement();
            ResultSet refResults = refGet.executeQuery("SELECT * FROM reference_timeseries TABLESAMPLE BERNOULLI (25)"); //TODO: fix hardcoded queries
            VarstarsRef refobj = null;
            String type = null;
            VarstarFeatureSet featureSet = null;
            Field[] fields = VarstarFeatureSet.class.getDeclaredFields();
            ObjectMapper om = new ObjectMapper();
            while (refResults.next()) {
                featureSet = new VarstarFeatureSet();
                type = refResults.getString("type");
                BeanUtils.setProperty(featureSet,"timeseriesObs",om.readValue(refResults.getString("timeseries"), new TypeReference<Map<Double,Double>>(){}));
                for(int i = 0; i<fields.length;i++){
                    if(fields[i].getType() == Double.class){
                        try {
                            Optional<Double> val = Optional.of((Double) refResults.getDouble(fields[i].getAnnotation(Column.class).name()));
                            BeanUtils.setProperty(featureSet,fields[i].getName(),val.orElse(0.0));
                        } catch (Error e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                }
                refobj = new VarstarsRef(featureSet, type);
                try {
                    this.refSet.add(refobj);
                }catch (Exception e){
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
                BeanUtils.setProperty(featureSet,"timeseriesObs",om.readValue(igResults.getString("timeseries"), new TypeReference<Map<Double,Double>>(){}));
                for(int i = 0; i<fields.length;i++){
                    if(fields[i].getType() == Double.class){
                        try {
                            Optional<Double> val = Optional.of((Double) igResults.getDouble(fields[i].getAnnotation(Column.class).name()));
                            BeanUtils.setProperty(featureSet,fields[i].getName(),val.orElse(0.0));
                        } catch (Error e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                }
                igobj = new VarstarsIG(featureSet, name);
                try {
                    this.igList.add(igobj);
                }catch (Exception e){
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
}

