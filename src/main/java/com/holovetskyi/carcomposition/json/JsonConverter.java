package com.holovetskyi.carcomposition.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Optional;

public class JsonConverter<T> {

    private final String jsonFilename;
    private final Gson gson = initVariable();
    protected JsonConverter(String jsonFilename) {
        this.jsonFilename = jsonFilename;
    }

    static Gson initVariable(){
        return new GsonBuilder().setPrettyPrinting().create();
    }

    public void toJson(final T element) {
        try (FileWriter fileWriter = new FileWriter(jsonFilename)) {
            gson.toJson(element, fileWriter);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Optional<T> fromJson() {
        try (FileReader fileReader = new FileReader(jsonFilename)) {
            return Optional.of(gson.fromJson(fileReader, getType()));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private Type getType(){
        return ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
}
