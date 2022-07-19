package com.holovetskyi.carcomposition.car.web.dto;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Optional;

public class ValidatorDto<T extends Enum> {

    private T[] t;


    public Optional<T> isCorrectType(String type) {
        return Arrays.stream(t)
                .filter(t -> t.name().equalsIgnoreCase(type))
                .findFirst();
    }
    public boolean isPositive(BigDecimal price) {
        return price.compareTo(BigDecimal.ZERO) >= 0;
    }
}
