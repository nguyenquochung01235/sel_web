package utils;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class JsonReader {

    // =========================
    // READ JSON FILE AS JSONObject
    // =========================

    public static JSONObject readJsonObject(String filePath) {
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader(filePath)) {
            return (JSONObject) parser.parse(reader);
        } catch (IOException | ParseException e) {
            throw new RuntimeException("Failed to read JSON file: " + filePath, e);
        }
    }

    // =========================
    // READ JSON FILE AS HASHMAP
    // =========================

    public static HashMap<String, Object> readJsonAsMap(String filePath) {
        JSONObject jsonObject = readJsonObject(filePath);
        return convertJsonObjectToMap(jsonObject);
    }

    // =========================
    // GET VALUE BY KEY
    // =========================

    public static String getStringValue(String filePath, String key) {
        Object value = readJsonObject(filePath).get(key);
        if (value == null) {
            throw new RuntimeException("Key not found: " + key);
        }
        return value.toString();
    }

    public static int getIntValue(String filePath, String key) {
        Object value = readJsonObject(filePath).get(key);
        return Integer.parseInt(value.toString());
    }

    public static boolean getBooleanValue(String filePath, String key) {
        Object value = readJsonObject(filePath).get(key);
        return Boolean.parseBoolean(value.toString());
    }

    // =========================
    // GET NESTED VALUE
    // =========================

    public static Object getNestedValue(String filePath, String... keys) {
        Object current = readJsonObject(filePath);

        for (String key : keys) {
            if (!(current instanceof JSONObject)) {
                throw new RuntimeException("Invalid key path: " + String.join(".", keys));
            }
            current = ((JSONObject) current).get(key);

            if (current == null) {
                throw new RuntimeException("Key not found: " + key);
            }
        }
        return current;
    }

    // =========================
    // CONVERT JSONObject → HashMap (RECURSIVE)
    // =========================

    private static HashMap<String, Object> convertJsonObjectToMap(JSONObject jsonObject) {
        HashMap<String, Object> map = new HashMap<>();

        for (Object keyObj : jsonObject.keySet()) {
            String key = keyObj.toString();
            Object value = jsonObject.get(key);

            if (value instanceof JSONObject) {
                map.put(key, convertJsonObjectToMap((JSONObject) value));
            } else if (value instanceof JSONArray) {
                map.put(key, convertJsonArrayToList((JSONArray) value));
            } else {
                map.put(key, value);
            }
        }
        return map;
    }

    // =========================
    // CONVERT JSONArray → List / Map
    // =========================

    private static Object convertJsonArrayToList(JSONArray jsonArray) {
        return jsonArray.stream().map(item -> {
            if (item instanceof JSONObject) {
                return convertJsonObjectToMap((JSONObject) item);
            }
            return item;
        }).toList();
    }

    // =========================
    // CHECK KEY EXISTS
    // =========================

    public static boolean isKeyPresent(String filePath, String key) {
        return readJsonObject(filePath).containsKey(key);
    }

    // =========================
    // PRINT JSON AS MAP (DEBUG)
    // =========================

    public static void printJsonAsMap(String filePath) {
        HashMap<String, Object> data = readJsonAsMap(filePath);
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
