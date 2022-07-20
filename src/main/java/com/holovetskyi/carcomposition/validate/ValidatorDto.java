package com.holovetskyi.carcomposition.validate;

import com.fasterxml.jackson.databind.util.EnumValues;
import com.holovetskyi.carcomposition.car.web.dto.type.CriterionTypeDto;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Optional;

public class ValidatorDto {
    public boolean isPositive(BigDecimal price) {
        return price.compareTo(BigDecimal.ZERO) >= 0;
    }
}

