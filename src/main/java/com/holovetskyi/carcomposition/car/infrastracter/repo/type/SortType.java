package com.holovetskyi.carcomposition.car.infrastracter.repo.type;

import java.util.Arrays;
import java.util.Optional;

public enum SortType {

    COMPONENTS, POWER, SIZE;

    public Optional<SortType> sortType(String sort){
       return Arrays.stream(values())
                .filter(c -> c.name().equalsIgnoreCase(sort))
                .findFirst();
    }
}
