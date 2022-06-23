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
import com.holovetskyi.carcomposition.car.web.dto.CreateFilenameDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.holovetskyi.carcomposition.car.application.Extensions.JSON;


@Service
@Slf4j
@RequiredArgsConstructor
public class CarInitializerService {

    private final ObjectMapper objectMapper;

    public void initialize(CreateFilenameDto filename) {
        List<Car> cars = build();
        toJson(filename, cars);
    }

    private void toJson(final CreateFilenameDto filenameDto, List<Car> cars) {

        try {
            FileWriter fileWriter = new FileWriter(filenameDto.filename.concat(JSON));
            objectMapper.writeValue(fileWriter, cars);
        } catch (Exception ex) {
            log.warn(ex.getMessage());
        }
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
