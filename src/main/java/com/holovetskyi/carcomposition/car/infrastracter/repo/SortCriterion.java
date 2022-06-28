package com.holovetskyi.carcomposition.car.infrastracter.repo;

import com.holovetskyi.carcomposition.car.infrastracter.repo.type.SortType;
import com.holovetskyi.carcomposition.car.web.dto.SortCriterionDto;
import lombok.Builder;
import lombok.Data;

import java.util.Optional;

@Data
@Builder
public class SortCriterion {
    @Builder.Default
    private SortType sortType = SortType.COMPONENTS;
    private boolean descending;

    public SortCriterion toSortCriterion(SortCriterionDto criterionDto) {
        Optional<SortType> sortCriterion = sortType.sortType(criterionDto.getSortedCriterion());
        return sortCriterion
                .map(type -> new SortCriterion(type, criterionDto.isDescending()))
                .orElseGet(() -> new SortCriterion(sortType, true));
    }
}
