package com.holovetskyi.carcomposition.car.web.dto;

import lombok.Data;

import java.util.Arrays;

import static com.holovetskyi.carcomposition.car.web.dto.CriterionDto.CriterionTypeDto.toCriterionType;


@Data
public class CriterionDto {

    String criterion;
    CriterionTypeDto typeDto;
    boolean descending;

    public CriterionDto(String criterion, boolean descending) {
        this.typeDto = toCriterionType(criterion);
        this.descending = descending;
    }

    public enum CriterionTypeDto {

        COMPONENTS, POWER, SIZE;

        public static CriterionTypeDto toCriterionType(String criterion) {
            return Arrays.stream(values())
                    .filter(c -> c.name().equalsIgnoreCase(criterion))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Invalid parameter: " + criterion));
        }
    }

}
