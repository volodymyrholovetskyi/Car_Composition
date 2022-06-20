package com.holovetskyi.carcomposition.domain;

import com.holovetskyi.carcomposition.domain.enums.CarBodyColor;
import com.holovetskyi.carcomposition.domain.enums.CarBodyType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarBody {

CarBodyColor carBodyColor;
CarBodyType carBodyType;
List<String> components;

}
