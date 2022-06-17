package com.holovetskyi.carcomposition.domain;

import com.holovetskyi.carcomposition.domain.body.CarBody;
import com.holovetskyi.carcomposition.domain.engine.Engine;
import com.holovetskyi.carcomposition.domain.wheel.Wheel;

import java.math.BigDecimal;

public class Car {

   String model;
   BigDecimal price;
   long mileage;
   Engine engine;
   CarBody carBody;
   Wheel wheel;
}
