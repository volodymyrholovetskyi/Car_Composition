package com.holovetskyi.carcomposition.car.web.dto;

import com.holovetskyi.carcomposition.car.web.dto.type.CriterionTypeDto;
import lombok.Data;


@Data
public class GetCriterionDto {

    String criterion;

    CriterionTypeDto criterionTypeDto;
    boolean descending;

    public GetCriterionDto(String criterion, boolean descending) {
//        this.criterionTypeDto = checkCriterion(criterion);
        this.criterionTypeDto = getCriterionTypeDto();
        this.descending = descending;
    }

}
