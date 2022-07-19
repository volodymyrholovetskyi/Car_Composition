package com.holovetskyi.carcomposition.car.web.dto.type;

import java.util.Arrays;

public enum EngineTypeDto {

    DIESEL, GASOLINE, LPG;

    public static EngineTypeDto checkCriterion(String engine) {
        return Arrays.stream(values())
                .filter(c -> c.name().equalsIgnoreCase(engine))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid parameter: " + engine));
    }
}
