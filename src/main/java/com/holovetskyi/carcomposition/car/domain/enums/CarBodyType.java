package com.holovetskyi.carcomposition.car.domain.enums;

import java.util.Arrays;

public enum CarBodyType {

    SEDAN, HATCHBACK, COMBI;


    public static CarBodyType toBodyType(String bodyType) {
        return Arrays.stream(values())
                .filter(c -> c.name().equalsIgnoreCase(bodyType))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid parameter: " + bodyType));
    }

}
