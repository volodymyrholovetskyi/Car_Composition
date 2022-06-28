package com.holovetskyi.carcomposition.car.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SortCriterionDto {

    String sortedCriterion;

    boolean descending;
}
