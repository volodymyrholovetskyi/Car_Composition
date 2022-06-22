package com.holovetskyi.carcomposition.json;

import com.holovetskyi.carcomposition.car.domain.Car;

import java.util.List;

public class JsonCarConverter extends JsonConverter<List<Car>> {
    public JsonCarConverter(String filename) {
        super(filename);
    }
}
