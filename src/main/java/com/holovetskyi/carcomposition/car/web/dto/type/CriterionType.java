package com.holovetskyi.carcomposition.car.web.dto.type;

import java.util.Arrays;

public enum CriterionType {


    COMPONENTS, POWER, SIZE;

    public static CriterionType checkCriterion(String criterion) {
        return Arrays.stream(values())
                .filter(c -> c.name().equalsIgnoreCase(criterion))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid parameter: " + criterion));
    }
}
