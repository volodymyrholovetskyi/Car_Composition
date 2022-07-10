package com.holovetskyi.carcomposition.car.web.dto;

import com.holovetskyi.carcomposition.car.web.dto.type.EngineTypeDto;
import lombok.Data;

@Data
    public class GetSpecificEngineDto {

        String engine;
        EngineTypeDto typeDto;

        public GetCriterionDto (String engine) {
            this.typeDto = checkCriterion(engine);
        }

}
