package com.holovetskyi.carcomposition.car.web;

import com.holovetskyi.carcomposition.car.application.CarService;
import com.holovetskyi.carcomposition.car.domain.Car;
import com.holovetskyi.carcomposition.car.web.dto.GetBodyTypeAndPriceDto;
import com.holovetskyi.carcomposition.car.web.dto.GetCriterionDto;
import com.holovetskyi.carcomposition.car.web.dto.GetSpecificEngineDto;
import com.holovetskyi.carcomposition.car.web.dto.type.BodyTypeDto;
import com.holovetskyi.carcomposition.car.web.dto.ValidatorDto;
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
            return service.sort(new GetCriterionDto(criterion.get(), descending.get()));
        } else if (criterion.isPresent()) {
            return service.sort(new GetCriterionDto(criterion.get(), false));
        }
        return Collections.emptyList();
    }

    @GetMapping(value = "/{body}/{from}/{to}")
    @ResponseStatus(OK)
    List<Car> sortCarsByBodyTypeAndPriceFromTo(
            @PathVariable String body,
            @PathVariable() BigDecimal from,
            @PathVariable BigDecimal to) {

        var carBody = new RestBodyTypeAndPrice(body, from, to);
        GetBodyTypeAndPriceDto priceDto = carBody.toBodyTypeAndPriceDto();

        return service.filterByBodyTypeAndPriceFromTo(priceDto);
    }

    @GetMapping(value = "sort/model")
    @ResponseStatus(OK)
    List<Car> sortByModelAboutSpecificEngine(@RequestParam String engine) {
        var dto = new GetSpecificEngineDto(engine);

        return service.sortByModelAboutSpecificEngineDto(dto);

    }

    @AllArgsConstructor
    public static class RestBodyTypeAndPrice {

        String body;
        BigDecimal from;
        BigDecimal to;

        public GetBodyTypeAndPriceDto toBodyTypeAndPriceDto() {
            ValidatorDto<BodyTypeDto> validatorDto = new ValidatorDto<>();
            BodyTypeDto bodyTypeDto = validatorDto.isCorrectType(body)
                    .orElseThrow(() -> new IllegalArgumentException("Param incorrect: " + body));
            if (!validatorDto.isPositive(from) && !validatorDto.isPositive(to)) {
                throw new IllegalArgumentException("Parameter cannot be negative!");
            }
            return new GetBodyTypeAndPriceDto(bodyTypeDto, from, to);
        }
    }
}

