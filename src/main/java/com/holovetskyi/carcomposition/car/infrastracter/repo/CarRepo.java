package com.holovetskyi.carcomposition.car.infrastracter.repo;

import com.holovetskyi.carcomposition.car.domain.Car;
import com.holovetskyi.carcomposition.validate.CarValidator;
import com.holovetskyi.carcomposition.validate.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CarRepo {

    private final CarValidator<Car> carValidator;

    private List<Car> cars = init();

    public static List<Car> init(List<Car> carList) {
        carList.stream()
                .filter(c -> V)
    }


}
