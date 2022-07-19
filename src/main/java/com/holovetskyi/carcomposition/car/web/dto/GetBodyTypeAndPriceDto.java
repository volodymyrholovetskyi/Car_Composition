package com.holovetskyi.carcomposition.car.web.dto;

import com.holovetskyi.carcomposition.car.web.dto.type.BodyTypeDto;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class GetBodyTypeAndPriceDto {

    String body;
    BodyTypeDto bodyTypeDto;
    BigDecimal from;
    BigDecimal to;


    public GetBodyTypeAndPriceDto(BodyTypeDto bodyTypeDto, BigDecimal from, BigDecimal to) {
        this.bodyTypeDto = bodyTypeDto;
        this.from = from;
        this.to = to;

    }

}
