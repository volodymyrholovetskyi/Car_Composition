package com.holovetskyi.carcomposition.car.domain;

import com.holovetskyi.carcomposition.car.domain.enums.CarBodyColor;
import com.holovetskyi.carcomposition.car.domain.enums.CarBodyType;
import lombok.*;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
@ToString
@Getter
public class CarBody {

CarBodyColor carBodyColor;

CarBodyType carBodyType;
List<String> components;

public CarBody withSortedComponents(){
    components.stream().sorted().toList();
    return this;
}

    public CarBody withSortedComponentsDesc(){
    components.stream().sorted(Comparator.comparing(c -> c.compareTo(c), Comparator.reverseOrder())).toList();
        return this;
    }

}
