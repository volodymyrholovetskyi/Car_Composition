package com.holovetskyi.carcomposition.car.application;

import com.holovetskyi.carcomposition.car.domain.Car;
import com.holovetskyi.carcomposition.car.infrastracter.repo.CarRepo;
import com.holovetskyi.carcomposition.car.infrastracter.repo.SortCriterion;
import com.holovetskyi.carcomposition.car.web.dto.SortCriterionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepo carRepo;

    public List<Car> sortComponents(SortCriterionDto criterion) {
        return carRepo.sort(SortCriterion.builder().build().toSortCriterion(criterion));
    }


}
