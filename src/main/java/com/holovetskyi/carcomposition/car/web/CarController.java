package com.holovetskyi.carcomposition.car.web;

import com.holovetskyi.carcomposition.car.application.CarService;
import com.holovetskyi.carcomposition.car.domain.Car;
import com.holovetskyi.carcomposition.car.web.dto.SortCriterionDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
    List<Car> sortCars(
            @RequestParam Optional<String> criterion,
            @RequestParam Optional<Boolean> ascending) {

        if (criterion.isPresent() && ascending.isPresent()) {
            return service.sort(new SortCriterionDto(criterion.get(), ascending.get()));
        } else if (criterion.isPresent()) {
            return service.sort(new SortCriterionDto(criterion.get(), true));
        }
        return Collections.emptyList();
    }

}

