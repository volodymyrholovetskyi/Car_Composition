package com.holovetskyi.carcomposition.car.web.dto;

import lombok.Data;

@Data
public class GetSpecificEngineDto {
    public String engine;

    public GetSpecificEngineDto(String engine) {
        this.engine = engine;
    }

}
