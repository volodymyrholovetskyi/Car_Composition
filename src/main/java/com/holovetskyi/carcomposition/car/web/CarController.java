package com.holovetskyi.carcomposition.car.web;

import com.holovetskyi.carcomposition.car.application.CarService;
import com.holovetskyi.carcomposition.car.domain.Car;
import com.holovetskyi.carcomposition.car.infrastracter.repo.SortCriterion;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("cars")
public class CarController {

    private final CarService service;

    @GetMapping("/{sortCriterion}/{descending}")
    public List<Car> sort(@PathVariable SortCriterion sortCriterion, @PathVariable Boolean descending) {
        return service.sortComponents(sortCriterion, descending);
    }

}
