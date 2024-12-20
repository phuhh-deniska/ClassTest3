package org.example;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;

public class JsonFileHandler {

    public static List<Person> readPersonsFromJson(String filePath) throws IOException {
        try (var reader = Files.newBufferedReader(Paths.get(filePath))) {
            Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, (JsonDeserializer<LocalDate>)
                    (json, type, context) -> LocalDate.parse(json.getAsString())).create();
            Type personListType = new TypeToken<List<Person>>() {}.getType();
            return gson.fromJson(reader, personListType);
        }
    }

    public static void writeToJson(Object data, String filePath) throws IOException {
        try (var writer = Files.newBufferedWriter(Paths.get(filePath))) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(data, writer);
        }
    }
}
