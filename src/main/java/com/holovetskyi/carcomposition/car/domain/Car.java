package com.holovetskyi.carcomposition.car.domain;

import lombok.*;

import java.math.BigDecimal;

import static com.holovetskyi.carcomposition.car.domain.enums.CarBodyType.toBodyType;
import static com.holovetskyi.carcomposition.car.domain.enums.EngineType.toEngineType;

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

    public boolean hasBodyType(String bodyType) {
        toBodyType(bodyType);
        return true;
    }

    public boolean hasEngine(String engine) {
        toEngineType(engine);
        return true;
    }

    public boolean hasPriceBetween(BigDecimal priceFrom, BigDecimal priceTo) {
        return this.price.compareTo(priceFrom) >= 0 && price.compareTo(priceTo) <= 0;
    }
}
