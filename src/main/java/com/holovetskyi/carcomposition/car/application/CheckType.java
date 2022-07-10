package com.holovetskyi.carcomposition.car.application.strategy;

import java.util.Arrays;

public class Check<T extends Enum> {

    private T[] t;

    public T check(String type) {
        return Arrays.stream(t)
                .filter(c -> c.name().equalsIgnoreCase(type))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid parameter: " + type));

    }
}
