package com.holovetskyi.carcomposition.car.web.dto.type;

import java.util.Arrays;

public enum CriterionTypeDto {

    COMPONENTS, POWER, SIZE;

    public static CriterionTypeDto checkCriterion(String criterion) {
        return Arrays.stream(values())
                .filter(c -> c.name().equalsIgnoreCase(criterion))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid parameter: " + criterion));
    }
}
