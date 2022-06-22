package com.holovetskyi.carcomposition.car.domain;

import com.holovetskyi.carcomposition.car.domain.enums.CarBodyColor;
import com.holovetskyi.carcomposition.car.domain.enums.CarBodyType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CarBody {

CarBodyColor carBodyColor;
CarBodyType carBodyType;
List<String> components;

}
