package com.holovetskyi.carcomposition.domain;

import com.holovetskyi.carcomposition.domain.enums.EngineType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Engine {

    EngineType engineType;

    double power;

}
