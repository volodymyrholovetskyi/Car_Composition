package com.holovetskyi.carcomposition.car.domain;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@ToString
@Getter
public class Car {

    String model;

    BigDecimal price;

    long mileage;

    Engine engine;

    CarBody carBody;

    Wheel wheel;

    public Car newCarWithSortedComponents() {
        return Car
                .builder()
                .model(model)
                .price(price)
                .mileage(mileage)
                .engine(engine)
                .carBody(carBody.withSortedComponents())
                .wheel(wheel)
                .build();
    }

    public Car newCarWithSortedComponentsDesc() {
        return Car
                .builder()
                .model(model)
                .price(price)
                .mileage(mileage)
                .engine(engine)
                .carBody(carBody.withSortedComponentsDesc())
                .wheel(wheel)
                .build();
    }
}
