package com.holovetskyi.carcomposition.car.application;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.holovetskyi.carcomposition.car.domain.Car;
import com.holovetskyi.carcomposition.car.domain.CarBody;
import com.holovetskyi.carcomposition.car.domain.Engine;
import com.holovetskyi.carcomposition.car.domain.Wheel;
import com.holovetskyi.carcomposition.car.domain.enums.CarBodyColor;
import com.holovetskyi.carcomposition.car.domain.enums.CarBodyType;
import com.holovetskyi.carcomposition.car.domain.enums.EngineType;
import com.holovetskyi.carcomposition.car.domain.enums.TyreType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
@PropertySource("classpath:parameter.properties")
public class CarInitializerService {
    private final ObjectMapper objectMapper;
    private final String filename;

    public CarInitializerService(ObjectMapper objectMapper, @Value("${car.filename}") String filename) {
        this.objectMapper = objectMapper;
        this.filename = filename;
    }

    public void initialize() {
        List<Car> cars = build();
        toJson(cars);
    }

    private void toJson(List<Car> cars) {
        try {
            objectMapper.writeValue(new File(filename), cars);
        } catch (IOException ex) {
            log.error("Car write ERROR: " + ex.getMessage());
        }
    }

    private List<Car> build() {
        return List.of(
                Car
                        .builder()
                        .model("AUDI")
                        .price(BigDecimal.valueOf(30_000))
                        .mileage(200_000L)
                        .engine(new Engine(EngineType.GASOLINE, 155))
                        .carBody(new CarBody(CarBodyColor.BLACK, CarBodyType.COMBI, List.of("CLIMATRONIC", "ABS")))
                        .wheel(new Wheel("BABSON", 16, TyreType.SUMMER))
                        .build(),

                Car
                        .builder()
                        .model("BMW")
                        .price(BigDecimal.valueOf(50_000))
                        .mileage(150_000L)
                        .engine(new Engine(EngineType.DIESEL, 150))
                        .carBody(new CarBody(CarBodyColor.BLACK, CarBodyType.HATCHBACK, List.of("CRUISE CONTROL", "DPF")))
                        .wheel(new Wheel("VELEX", 18, TyreType.SUMMER))
                        .build());
    }
}
