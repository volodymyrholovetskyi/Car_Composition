package com.holovetskyi.carcomposition.domain;

import com.holovetskyi.carcomposition.validate.Validator;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static com.holovetskyi.carcomposition.validate.Validator.*;
import static com.holovetskyi.carcomposition.validate.Validator.hasCapitalLetter;
import static com.holovetskyi.carcomposition.validate.Validator.hasEveryItemCapitalLetter;
import static com.holovetskyi.carcomposition.validate.Validator.isPositiveDecimal;
import static com.holovetskyi.carcomposition.validate.Validator.isPositiveDouble;
import static com.holovetskyi.carcomposition.validate.Validator.isPositiveLong;

@Component
public class CarValidator implements Validator<Car> {

    private final Map<String, String> errors = new HashMap<>();

    @Override
    public Map<String, String> validate(Car car) {

        if (car == null) {
            errors.put("car object", "null");
            return errors;
        }

        var model = car.model;
        if (model == null) {
            errors.put("model", "null");
            return errors;
        } else if (!model.matches("[A-Z ]+")) {
            errors.put("model", "not correct");
            return errors;
        }

        var price = car.price;
        if (price == null) {
            errors.put("price", "null");
            return errors;
        } else if (car.price.compareTo(BigDecimal.ZERO) < 0) {
            errors.put("price", "cannot be negative");
            return errors;
        }

        var mileage = car.mileage;
        if (car.mileage <= 0) {
            errors.put("mileage", "cannot be negative either null");
            return errors;
        }

//        var components = car.components;
//        if (components == null) {
//            errors.put("components", "null");
//            return errors;
//        }
//        Optional<String> component = components.stream()
//                .filter(c -> !c.matches("[A-Z ]+"))
//                .findFirst();
//
//        if (component.isPresent()) {
//            errors.put("components", "not correct");
//            return errors;
//        }
        return errors;
    }
}

