package utils;

import constants.ConfigFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ConfigReader {
    private static String configPath = "configs/";
    private static Map<String, Properties> configCache = new HashMap<>();
    private ConfigReader(){

    }

    public static Properties getProperties(ConfigFile configFile){
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

}
