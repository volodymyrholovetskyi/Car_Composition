package com.holovetskyi.carcomposition.car.application;

import com.holovetskyi.carcomposition.car.application.exception.CarServiceException;
import com.holovetskyi.carcomposition.car.application.type.SortType;
import com.holovetskyi.carcomposition.car.web.dto.SortCriterionDto;
import lombok.*;
import lombok.experimental.FieldDefaults;

import static com.holovetskyi.carcomposition.car.application.type.SortType.*;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class SortCriterion {
    SortType sortType;
    boolean ascending;

    public SortCriterion toSortCriterion(SortCriterionDto criterionDto) {
        System.out.println(criterionDto);
        return checkingParameter(criterionDto.getSortedCriterion())
                .map(type -> new SortCriterion(type, criterionDto.isDescending()))
                .orElseThrow(() -> new CarServiceException("Invalid parameter: " + criterionDto.getSortedCriterion()));
    }
}
