package com.holovetskyi.carcomposition.car.domain;

import com.holovetskyi.carcomposition.car.domain.enums.CarBodyType;
import com.holovetskyi.carcomposition.car.domain.enums.EngineType;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static com.holovetskyi.carcomposition.car.domain.enums.EngineType.*;

public interface CarUtils {

    Comparator<Car> compareByModel = Comparator.comparing(car -> car.model);
    Comparator<Car> compareByPowerDesc = Comparator.comparing(car -> car.engine.power);
    Comparator<Car> compareBySizeDesc = Comparator.comparing(car -> car.wheel.size);

    Comparator<Car> compareBySize = Comparator.comparing(car -> car.wheel.size, Comparator.reverseOrder());
    Comparator<Car> compareByPower = Comparator.comparing(car -> car.engine.power, Comparator.reverseOrder());

    List<EngineType> engineType = Arrays.stream(values()).toList();

}
