package com.holovetskyi.carcomposition.car.domain;

import com.holovetskyi.carcomposition.car.domain.enums.EngineType;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Getter
public class Engine {

    EngineType engineType;
    double power;

}
