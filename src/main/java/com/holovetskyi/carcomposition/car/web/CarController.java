package com.holovetskyi.carcomposition.car.web;

import com.holovetskyi.carcomposition.car.application.CarService;
import com.holovetskyi.carcomposition.car.domain.Car;
import com.holovetskyi.carcomposition.car.web.dto.GetBodyTypeAndPriceDto;
import com.holovetskyi.carcomposition.car.web.dto.GetCriterionDto;
import com.holovetskyi.carcomposition.car.web.dto.GetSpecificEngineDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.OK;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("cars")
public class CarController {

    private final CarService service;

    @GetMapping(value = "/sort/criterion")
    @ResponseStatus(OK)
    List<Car> sortCarsByCriterion(
            @RequestParam Optional<String> criterion,
            @RequestParam Optional<Boolean> ascending) {

        if (criterion.isPresent() && ascending.isPresent()) {
            return service.sort(new GetCriterionDto(criterion.get(), ascending.get()));
        } else if (criterion.isPresent()) {
            return service.sort(new GetCriterionDto(criterion.get(), true));
        }
        return Collections.emptyList();
    }

    @GetMapping(value = "/{body}/{from}/{to}")
    @ResponseStatus(OK)
    List<Car> sortCarsByBodyTypeAndPriceFromTo(
            @PathVariable String body,
            @PathVariable() BigDecimal from,
            @PathVariable BigDecimal to) {

        var carBody = new GetBodyTypeAndPriceDto(body, from, to);

        return service.filterByBodyTypeAndPriceFromTo(carBody);
    }

    @GetMapping(value = "sort/model")
    @ResponseStatus(OK)
    List<Car> sortByModelAboutSpecificEngine(@RequestParam String engine) {
        var dto = new GetSpecificEngineDto(engine);

        return service.sortByModelAboutSpecificEngineDto(dto);

    }
}

