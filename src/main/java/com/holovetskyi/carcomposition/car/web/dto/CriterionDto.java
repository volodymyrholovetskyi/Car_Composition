package com.holovetskyi.carcomposition.car.web.dto;

import com.holovetskyi.carcomposition.car.web.dto.type.CriterionType;
import lombok.Data;

import static com.holovetskyi.carcomposition.car.web.dto.type.CriterionType.checkCriterion;


@Data
public class CriterionDto {

    String criterion;

    CriterionType criterionType;
    boolean descending;

    public CriterionDto(String criterion, boolean descending) {
        this.criterionType = checkCriterion(criterion);
        this.descending = descending;
    }

}
