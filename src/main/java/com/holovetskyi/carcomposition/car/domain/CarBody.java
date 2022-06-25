package com.holovetskyi.carcomposition.car.domain;

import com.holovetskyi.carcomposition.car.domain.enums.CarBodyColor;
import com.holovetskyi.carcomposition.car.domain.enums.CarBodyType;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Setter
@Getter
public class CarBody {

CarBodyColor carBodyColor;

CarBodyType carBodyType;

List<String> components;

}
