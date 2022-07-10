package com.holovetskyi.carcomposition.car.domain;

import com.holovetskyi.carcomposition.car.web.dto.type.BodyTypeDto;
import lombok.*;

import java.math.BigDecimal;
import java.util.Arrays;

import static com.holovetskyi.carcomposition.car.web.dto.type.BodyTypeDto.*;

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

    public boolean hasBodyType(BodyTypeDto bodyTypeDto) {
        return Arrays.stream(values())
                .anyMatch(body -> body == bodyTypeDto);
    }

    public boolean hasPriceBetween(BigDecimal priceFrom, BigDecimal priceTo) {
        return this.price.compareTo(priceFrom) >= 0 && price.compareTo(priceTo) <= 0;
    }
}
