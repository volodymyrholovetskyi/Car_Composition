package com.holovetskyi.carcomposition.car.web.dto;

import com.holovetskyi.carcomposition.car.web.dto.type.CriterionTypeDto;
import lombok.Data;

import static com.holovetskyi.carcomposition.car.web.dto.type.CriterionTypeDto.checkCriterion;


@Data
public class GetCriterionDto {

    String criterion;

    CriterionTypeDto criterionTypeDto;
    boolean descending;

    public GetCriterionDto(String criterion, boolean descending) {
        this.criterionTypeDto = checkCriterion(criterion);
        this.descending = descending;
    }

}
