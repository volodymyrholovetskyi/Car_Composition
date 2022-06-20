package com.holovetskyi.carcomposition.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Car {

   String model;
   BigDecimal price;
   long mileage;
   Engine engine;
   CarBody carBody;
   Wheel wheel;
}
