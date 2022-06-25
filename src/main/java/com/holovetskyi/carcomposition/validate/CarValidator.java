package com.holovetskyi.carcomposition.validate;

import com.holovetskyi.carcomposition.car.domain.Car;
import com.holovetskyi.carcomposition.car.domain.CarBody;
import com.holovetskyi.carcomposition.car.domain.Engine;
import com.holovetskyi.carcomposition.car.domain.Wheel;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static com.holovetskyi.carcomposition.validate.Validator.*;

@Component
public class CarValidator<T> implements Validator<Car> {

    private final Map<String, String> errors = new HashMap<>();

    @Override
    public Map<String, String> validate(Car car) {

        if (car == null) {
            errors.put("car object", "null");
            return errors;
        }

        var model = car.getModel();
        if (!validateModel(model)) {
            return errors;
        }

        var price = car.getPrice();
        if (price == null) {
            errors.put("price", "null");
            return errors;
        } else if (!isPositiveDecimal(price)) {
            errors.put("price", "cannot be negative");
            return errors;
        }

        var mileage = car.getMileage();
        if (!isPositiveLong(mileage)) {
            errors.put("mileage", "cannot be negative either null");
            return errors;
        }

        Engine engine = car.getEngine();
        if (!validateEngine(engine)) {
            return errors;
        }

        CarBody carBody = car.getCarBody();
        if (!validateCarBody(carBody)) {
            return errors;
        }

        Wheel wheel = car.getWheel();
        if (!validateModel(wheel.getModel())) {
            return errors;
        }
        if (!isPositiveInteger(wheel.getSize())) {
            errors.put("wheel size", "cannot be negative either null");
            return errors;
        }

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
        double power = engine.getPower();

        if (!isPositiveDouble(power)) {
            errors.put("power", "cannot be negative either null");
            return false;
        }
        return true;
    }

    private boolean validateCarBody(CarBody carBody) {
        if (carBody.getComponents() == null) {
            errors.put("model", "null");
            return false;
        } else if (!hasEveryItemCapitalLetter(carBody.getComponents(), "[A-Z ]+")) {
            errors.put("components", "not correct");
            return false;
        }
        return true;
    }
}

