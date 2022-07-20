package com.holovetskyi.carcomposition.car.domain.enums;

import java.util.Arrays;

public enum EngineType {
    DIESEL, GASOLINE, LPG;

    public static EngineType toEngineType(String engine) {
        return Arrays.stream(values())
                .filter(c -> c.name().equalsIgnoreCase(engine))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid parameter: " + engine));
    }
}
