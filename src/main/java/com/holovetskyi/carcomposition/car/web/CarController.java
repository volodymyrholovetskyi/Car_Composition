package com.holovetskyi.carcomposition.car.web;

import com.holovetskyi.carcomposition.car.application.CarService;
import com.holovetskyi.carcomposition.car.domain.Car;
import com.holovetskyi.carcomposition.car.web.dto.PriceBetweenDto;
import com.holovetskyi.carcomposition.car.web.dto.CriterionDto;
import com.holovetskyi.carcomposition.car.web.dto.SpecificEngineDto;
import com.holovetskyi.carcomposition.validate.ValidatorDto;
import lombok.AllArgsConstructor;
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

    @GetMapping(value = "/sort")
    @ResponseStatus(OK)
    List<Car> sortCarsByCriterion(
            @RequestParam Optional<String> criterion,
            @RequestParam Optional<Boolean> descending) {

        if (criterion.isPresent() && descending.isPresent()) {
            return service.sort(new CriterionDto(criterion.get(), descending.get()));
        } else if (criterion.isPresent()) {
            return service.sort(new CriterionDto(criterion.get(), false));
        }
        return Collections.emptyList();
    }

    @GetMapping(value = "/{body}/{from}/{to}")
    @ResponseStatus(OK)
    List<Car> sortCarsByBodyTypeAndPriceFromTo(
            @PathVariable String body,
            @PathVariable() BigDecimal from,
            @PathVariable BigDecimal to) {

        return service.filterByBodyTypeAndPriceFromTo(new PriceBetweenDto(body, from, to));
    }

    @GetMapping(value = "sort/model")
    @ResponseStatus(OK)
    List<Car> sortByModelAboutSpecificEngine(@RequestParam String engine) {

        return service.sortByModelAboutSpecificEngineDto(new SpecificEngineDto(engine));
    }

//    @AllArgsConstructor
//    public static class RestSpecificEngine {
//
//        String engine;
//
//        public SpecificEngineDto toSpecificEngine () {
//            var validatorDto = new ValidatorDto<EngineTypeDto>()
//                    .isCorrectType(engine)
//                    .orElseThrow(() -> new IllegalArgumentException("Param incorrect: " + engine));
//            return new SpecificEngineDto(validatorDto);
//        }
//    }
}

