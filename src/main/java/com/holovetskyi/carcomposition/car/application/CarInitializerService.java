package com.holovetskyi.carcomposition.car.application;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.ReferenceType;
import com.holovetskyi.carcomposition.car.domain.Car;
import com.holovetskyi.carcomposition.car.domain.CarBody;
import com.holovetskyi.carcomposition.car.domain.Engine;
import com.holovetskyi.carcomposition.car.domain.Wheel;
import com.holovetskyi.carcomposition.car.domain.enums.CarBodyColor;
import com.holovetskyi.carcomposition.car.domain.enums.CarBodyType;
import com.holovetskyi.carcomposition.car.domain.enums.EngineType;
import com.holovetskyi.carcomposition.car.domain.enums.TyreType;
import com.holovetskyi.carcomposition.car.web.dto.CreateFilenameDto;
import com.holovetskyi.carcomposition.commons.BasePath;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.holovetskyi.carcomposition.commons.BasePath.*;
import static com.holovetskyi.carcomposition.commons.Extensions.JSON;


@Service
@Slf4j
@RequiredArgsConstructor
public class CarInitializerService {

    private final ObjectMapper objectMapper;
    public void initialize(CreateFilenameDto filename) {
        List<Car> cars = build();
        toJson(filename, cars);
        initRepo(filename);
    }

    private void toJson(final CreateFilenameDto filenameDto, List<Car> cars) {

        try {
            FileWriter fileWriter = new FileWriter(filenameDto.filename.concat(JSON));
            objectMapper.writeValue(fileWriter, cars);
        } catch (IOException ex) {
            log.warn("Cars write error: " + ex.getMessage());
        }
    }

    private void initRepo(CreateFilenameDto filenameDto) {
        try {
           File file = new File(BASE_PATH.concat(filenameDto.filename + JSON));
            List<Car> cars = objectMapper.readValue(file, new TypeReference<>() {});

            cars.forEach(System.out::println);
        } catch (IOException ex){
            log.warn("Cars read error: " + ex.getMessage());
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
