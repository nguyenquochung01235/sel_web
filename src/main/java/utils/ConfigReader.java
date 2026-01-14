package utils;

import constants.ConfigFile;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ConfigReader {
    private static final String configPath = "configs/";
    private static Map<String, Properties> configCache = new HashMap<>();
    private static final String testConfigPath = "src/test/java/pages/properties/";
    private static Map<String, Properties> testConfigCache = new HashMap<>();
    private ConfigReader(){

    }

    private static Properties getProperties(ConfigFile configFile){
        String configFileName = configFile.getConfigFileName();
        if(configCache.containsKey(configFileName)){
            return configCache.get(configFileName);
        }
        String configFilePath = configPath.concat(configFileName);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(configFilePath));
            Properties properties = new Properties();
            properties.load(reader);
            configCache.put(configFileName, properties);
            return properties;
        }catch (IOException e){
            System.err.println(e.getMessage());
            throw new RuntimeException("");
        }
    }

    public static String getSpecificProperty(ConfigFile configFile, String key){
        Properties properties = getProperties(configFile);
        String value = properties.getProperty(key);

        if(Objects.nonNull(value)) return value;
        else throw new RuntimeException("Can not found key '" + key + "' in " + configFile.getConfigFileName());
    }

    public static List<String> getArrayProperty(ConfigFile configFile, String key, String delimiter){

        Properties properties = getProperties(configFile);
        String value = properties.getProperty(key);

        if(Objects.nonNull(value)) {
           return Arrays.asList(value.split(delimiter));
        }
        else throw new RuntimeException("Can not found key '" + key + "' in " + configFile.getConfigFileName());
    }

    private static Properties getTestProperties(String testPropertiesFileName){
        String configFilePath = testConfigPath.concat(testPropertiesFileName);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(configFilePath));
            Properties properties = new Properties();
            properties.load(reader);
            testConfigCache.put(testPropertiesFileName, properties);
            return properties;
        }catch (IOException e){
            System.err.println(e.getMessage());
            throw new RuntimeException();
        }
    }

    public static String getSpecificTestProperty(String testPropertiesFileName, String key){
        Properties properties = getTestProperties(testPropertiesFileName);
        String value = properties.getProperty(key);

        if(Objects.nonNull(value)) return value;
        else throw new RuntimeException("Can not found key '" + key + "' in " + testPropertiesFileName);
    }


}
