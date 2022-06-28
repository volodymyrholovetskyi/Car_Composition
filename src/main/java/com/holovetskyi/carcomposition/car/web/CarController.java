package com.holovetskyi.carcomposition.car.web;

import com.holovetskyi.carcomposition.car.application.CarService;
import com.holovetskyi.carcomposition.car.domain.Car;
import com.holovetskyi.carcomposition.car.domain.Wheel;
import com.holovetskyi.carcomposition.car.domain.enums.TyreType;
import com.holovetskyi.carcomposition.car.web.dto.SortCriterionDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.batch.BatchDataSource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("cars")
public class CarController {

    private final CarService service;

    @GetMapping(value = "/sort")
    List<Car> allSortCar(
            @RequestParam Optional<String> criterion,
            @RequestParam Optional<Boolean> descending) {

        if (criterion.isPresent() && descending.isPresent()) {
            return service.sortComponents(new SortCriterionDto(criterion.get(), descending.get()));
        } else if (criterion.isPresent()) {
            return service.sortComponents(new SortCriterionDto(criterion.get(), false));
        }
        return Collections.emptyList();
    }

}

