package com.holovetskyi.carcomposition.car.web.dto;

import com.holovetskyi.carcomposition.car.web.dto.type.BodyTypeDto;
import lombok.Data;

import java.math.BigDecimal;

import static com.holovetskyi.carcomposition.car.web.dto.type.BodyTypeDto.checkBodyType;

@Data
public class GetBodyTypeAndPriceDto {

    String body;
    BodyTypeDto bodyTypeDto;
    BigDecimal from;
    BigDecimal to;


    public GetBodyTypeAndPriceDto(String body, BigDecimal from, BigDecimal to) {
        this.bodyTypeDto = checkBodyType(body);
        this.from = from;
        this.to = to;
    }
}
