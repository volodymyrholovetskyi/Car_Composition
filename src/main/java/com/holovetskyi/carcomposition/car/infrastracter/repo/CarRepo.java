package com.holovetskyi.carcomposition.car.infrastracter.repo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.holovetskyi.carcomposition.car.domain.Car;
import com.holovetskyi.carcomposition.validate.CarValidator;
import com.holovetskyi.carcomposition.validate.Validator;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
@Slf4j
@PropertySource("classpath:parameter.properties")
public class CarRepo {
    private final ObjectMapper objectMapper;
    private final String filename;

    private final CarValidator carValidator;

    private List<Car> cars = new ArrayList<>();

    public CarRepo(ObjectMapper objectMapper,CarValidator carValidator, @Value("${base.path.filename}") String filename) {
        this.objectMapper = objectMapper;
        this.carValidator = carValidator;
        this.filename = filename;
    }

    public List<Car> init() {
        try {
            return objectMapper.readValue(new File(filename), new TypeReference<List<Car>>() {
                    })
                    .stream()
                    .filter(car -> Validator.validate(carValidator, car))
                    .filter(car -> cars.add(car))
                    .toList();

        } catch (IOException ex) {
            log.error("Car read ERROR: " + ex.getMessage());
        }
        return Collections.emptyList();
    }



}
