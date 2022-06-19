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
       if (!validateModel(model)){
           return errors;
       }

        var price = car.price;
        if (price == null) {
            errors.put("price", "null");
            return errors;
        } else if (!isPositiveDecimal(price)) {
            errors.put("price", "cannot be negative");
            return errors;
        }

        var mileage = car.mileage;
        if (!isPositiveLong(mileage)) {
            errors.put("mileage", "cannot be negative either null");
            return errors;
        }

        Engine engine = car.engine;
        if (!validateEngine(engine)) {
            return errors;
        }

        CarBody carBody = car.carBody;
        if (!validateCarBody(carBody)) {
            return errors;
        }

        Wheel wheel = car.wheel;
        if (!validateModel(wheel.model)){
            return errors;
        }

        isPositiveInteger(wheel.size);
            return errors;
    }

    private boolean validateModel(String model) {
        if (model == null) {
            errors.put("model", "null");
            return false;
        } else if (!hasCapitalLetter(model, "[A-Z ]+")) {
            errors.put("model", "not correct");
            return false;
        }
        return true;
    }

    private boolean validateEngine(Engine engine) {
        double power = engine.power;

        if (!isPositiveDouble(power)) {
            errors.put("power", "cannot be negative either null");
            return false;
        }
        return true;
    }

    private boolean validateCarBody(CarBody carBody) {
        if (carBody.components == null) {
            errors.put("model", "null");
            return false;
        } else if (!hasEveryItemCapitalLetter(carBody.components, "[A-Z ]+")) {
            errors.put("model", "not correct");
            return false;
        }
        return true;
    }
}

