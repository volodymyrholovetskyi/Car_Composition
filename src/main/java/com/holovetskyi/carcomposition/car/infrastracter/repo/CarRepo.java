package com.holovetskyi.carcomposition.car.infrastracter.repo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.holovetskyi.carcomposition.car.domain.Car;
import com.holovetskyi.carcomposition.car.infrastracter.repo.type.SortType;
import com.holovetskyi.carcomposition.validate.CarValidator;
import com.holovetskyi.carcomposition.validate.Validator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.holovetskyi.carcomposition.car.domain.CarUtils.*;
import static com.holovetskyi.carcomposition.car.infrastracter.repo.type.SortType.POWER;
import static com.holovetskyi.carcomposition.car.infrastracter.repo.type.SortType.SIZE;
import static com.holovetskyi.carcomposition.validate.Validator.*;

@Repository
@Slf4j
@PropertySource("classpath:parameter.properties")
public class CarRepo {
    private final ObjectMapper objectMapper;
    private final String filename;

    private final CarValidator carValidator;

    private List<Car> cars = new ArrayList<>();

    public CarRepo(ObjectMapper objectMapper, CarValidator carValidator, @Value("${base.path.filename}") String filename) {
        this.objectMapper = objectMapper;
        this.carValidator = carValidator;
        this.filename = filename;
    }

    public List<Car> init() {
        try {
            return objectMapper.readValue(new File(filename), new TypeReference<List<Car>>() {
                    })
                    .stream()
                    .filter(car -> validate(carValidator, car))
                    .filter(car -> cars.add(car))
                    .toList();

        } catch (IOException ex) {
            log.error("Car read ERROR: " + ex.getMessage());
        }
        return Collections.emptyList();
    }

    /**
     * Metoda zwraca kolekcję samochodów posortowaną według kryterium
     podanego jako argument. Metoda powinna umożliwiać sortowanie
     według ilości komponentów, mocy silnika oraz rozmiaru opony.
     Dodatkowo metoda powinna umożliwiać sortowanie rosnąco oraz
     malejąco.
     */

    public List<Car> sort(SortCriterion criterion) {

        return criterion.isDescending() ?
                switch (criterion.getSortType()) {
                    case POWER -> cars.stream().sorted(compareByPowerDesc).toList();
                    case SIZE -> cars.stream().sorted(compareBySizeDesc).toList();
                    default -> cars.stream().map(Car::newCarWithSortedComponentsDesc).toList();
                } :
                switch (criterion.getSortType()) {
                    case POWER -> cars.stream().sorted(compareByPower).toList();
                    case SIZE -> cars.stream().sorted(compareBySize).toList();
                    default -> cars.stream().map(Car::newCarWithSortedComponents).toList();
                };

    }
}
