package com.holovetskyi.carcomposition.car.domain;

import com.holovetskyi.carcomposition.car.domain.enums.TyreType;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
@ToString
@Getter
public class Wheel {

    String model;
    int size;
    TyreType tyreType;
}
