package com.holovetskyi.carcomposition.car.application.type;

import java.util.Arrays;
import java.util.Optional;

public enum SortType {

    COMPONENTS, POWER, SIZE;

    public static Optional<SortType> checkingParameter(String sort){
       return Arrays.stream(values())
                .filter(c -> c.name().equalsIgnoreCase(sort))
                .findFirst();
    }
}
