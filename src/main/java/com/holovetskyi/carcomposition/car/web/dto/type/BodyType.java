package com.holovetskyi.carcomposition.car.web.dto.type;

import com.holovetskyi.carcomposition.car.domain.enums.CarBodyType;

import java.util.Arrays;
import java.util.Optional;

public enum BodyType {

    SEDAN, HATCHBACK, COMBI;

    public static BodyType checkBodyType(String bodyType) {
        return Arrays.stream(values())
                .filter(body -> body.name().equalsIgnoreCase(bodyType))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid parameter: " + bodyType));
    }
}
