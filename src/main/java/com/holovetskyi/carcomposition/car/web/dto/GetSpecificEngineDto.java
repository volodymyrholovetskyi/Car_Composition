package com.holovetskyi.carcomposition.car.web.dto;

import com.holovetskyi.carcomposition.car.web.dto.type.EngineTypeDto;
import lombok.Data;

@Data
public class GetSpecificEngineDto {
    public EngineTypeDto engine;

    public GetSpecificEngineDto(EngineTypeDto engine) {
        this.engine = engine;
    }

}
