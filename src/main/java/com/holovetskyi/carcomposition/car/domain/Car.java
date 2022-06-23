package com.holovetskyi.carcomposition.car.domain;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
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
}
