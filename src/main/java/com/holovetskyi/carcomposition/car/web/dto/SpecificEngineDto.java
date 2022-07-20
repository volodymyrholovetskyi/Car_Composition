package com.holovetskyi.carcomposition.car.web.dto;

import lombok.Data;

@Data
public class SpecificEngineDto {
    public String engine;

    public SpecificEngineDto(String engine) {
        this.engine = engine;
    }

}
