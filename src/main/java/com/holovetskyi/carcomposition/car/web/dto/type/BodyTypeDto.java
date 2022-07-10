package com.holovetskyi.carcomposition.car.web.dto.type;

import java.util.Arrays;

public enum BodyTypeDto {

    SEDAN, HATCHBACK, COMBI;

    public static BodyTypeDto checkBodyType(String bodyType) {
        return Arrays.stream(values())
                .filter(body -> body.name().equalsIgnoreCase(bodyType))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid parameter: " + bodyType));
    }
}
