package com.holovetskyi.carcomposition.car.application;

import com.holovetskyi.carcomposition.car.domain.Car;
import com.holovetskyi.carcomposition.car.domain.CarBody;
import com.holovetskyi.carcomposition.car.domain.Engine;
import com.holovetskyi.carcomposition.car.domain.Wheel;
import com.holovetskyi.carcomposition.car.domain.enums.*;
import com.holovetskyi.carcomposition.car.web.dto.CreateFilenameDto;
import com.holovetskyi.carcomposition.json.JsonCarConverter;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.holovetskyi.carcomposition.car.application.Extensions.*;

@Service
public class CarInitializerService {

    public void initialize(CreateFilenameDto filename) {
        List<Car> cars = build();
        createCar(cars, filename);
    }

    private void createCar(List<Car> cars, final CreateFilenameDto filenameDto) {
        JsonCarConverter carConverter = new JsonCarConverter(filenameDto.filename + JSON);
        carConverter.toJson(cars);
    }

    private List<Car> build() {
        List<Car> cars = new ArrayList<>();
        Car bmw = Car
                .builder()
                .model("BMW")
                .price(new BigDecimal("2000"))
                .mileage(3500L)
                .engine(new Engine(EngineType.DIESEL, 150))
                .carBody(new CarBody(CarBodyColor.BLACK, CarBodyType.COMBI, List.of("DPF", "LPG")))
                .wheel(new Wheel("CRAB", 20, TyreType.SUMMER))
                .build();

        Car audi = Car
                .builder()
                .model("BMW")
                .price(new BigDecimal("2000"))
                .mileage(3500L)
                .engine(new Engine(EngineType.DIESEL, 150))
                .carBody(new CarBody(CarBodyColor.BLACK, CarBodyType.COMBI, List.of("DPF", "LPG")))
                .wheel(new Wheel("CRAB", 20, TyreType.SUMMER))
                .build();
        cars.add(bmw);
        cars.add(audi);
        return cars;
    }
}
