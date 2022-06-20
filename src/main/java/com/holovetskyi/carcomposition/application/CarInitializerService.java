package com.holovetskyi.carcomposition.application;

import com.holovetskyi.carcomposition.application.port.CarInitializerUseCase;
import com.holovetskyi.carcomposition.domain.Car;
import com.holovetskyi.carcomposition.domain.CarBody;
import com.holovetskyi.carcomposition.domain.Engine;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.holovetskyi.carcomposition.domain.enums.CarBodyColor.BLACK;
import static com.holovetskyi.carcomposition.domain.enums.CarBodyType.COMBI;
import static com.holovetskyi.carcomposition.domain.enums.EngineType.DIESEL;

@Service
public class CarInitializerService implements CarInitializerUseCase {

    private final List cars = build();


    @Override
    public void initialize() {
        build();
        toJson();
    }

    private void toJson() {
    }

    private List<Car> build() {
       return List.of(
                Car
                        .builder()
                        .model("BMW")
                        .price(new BigDecimal("2000"))
                        .mileage(3500L)
                        .engine(new Engine(DIESEL, 150))
                        .carBody(new CarBody(BLACK, COMBI, List.of("DPF", "LPG")))
                        .build(),

                Car
                        .builder()
                        .model("BMW")
                        .price(new BigDecimal("2000"))
                        .mileage(3500L)
                        .engine(new Engine(DIESEL, 150))
                        .carBody(new CarBody(BLACK, COMBI, List.of("DPF", "LPG")))
                        .build()
        );
    }
}
