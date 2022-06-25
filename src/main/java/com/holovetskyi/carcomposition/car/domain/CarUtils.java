package com.holovetskyi.carcomposition.car.domain;

import java.util.Comparator;

public interface CarUtils {


    Comparator<Car> compareByPowerDesc = Comparator.comparing(car -> car.engine.power);
    Comparator<Car> compareBySizeDesc = Comparator.comparing(car -> car.wheel.size);

    Comparator<Car> compareBySize = Comparator.comparing(car -> car.wheel.size, Comparator.reverseOrder());
    Comparator<Car> compareByPower = Comparator.comparing(car -> car.engine.power, Comparator.reverseOrder());
}
