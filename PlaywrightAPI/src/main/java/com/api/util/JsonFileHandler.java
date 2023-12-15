package com.api.util;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import org.apache.commons.io.FileUtils;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JsonFileHandler {
    public static String resourceDirectory = "C:\\Users\\kottari.s.d\\Desktop\\Playwrite\\PlaywrightJava\\PlaywrightAPI\\src\\main\\java\\JsonResource\\";

    private static Object loadJSONFile(String resourceName, Class containerClass, String directory) {
        JsonReader reader;
        try {
            reader = new JsonReader(new FileReader(directory + resourceName));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Object object = new Gson().fromJson(reader, containerClass);
        return object;
    }

    public static <T> Object loadJSONTemplate(String resourceName, Class<T> containerClass, String directory) {
        return loadJSONFile(resourceName, containerClass, directory);
    }

    public static JSONObject convertJsonFileToJsonObject(String fileName) {
        String jsonFilePath = resourceDirectory + fileName;
        File jsonFile = new File(jsonFilePath);
        String jsonContent = null;
        try {
            jsonContent = FileUtils.readFileToString(jsonFile, "UTF-8");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        JSONObject jsonObject = new JSONObject(jsonContent);
        return jsonObject;
    }
}
