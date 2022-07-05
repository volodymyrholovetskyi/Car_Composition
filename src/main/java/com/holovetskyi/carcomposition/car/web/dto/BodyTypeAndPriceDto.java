package com.holovetskyi.carcomposition.car.web.dto;

import com.holovetskyi.carcomposition.car.web.dto.type.BodyType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

import static com.holovetskyi.carcomposition.car.web.dto.type.BodyType.checkBodyType;

@Data
public class BodyTypeAndPriceDto {

    String body;
    BodyType bodyType;
    BigDecimal from;
    BigDecimal to;


    public BodyTypeAndPriceDto(String body, BigDecimal from, BigDecimal to) {
        this.bodyType = checkBodyType(body);
        this.from = from;
        this.to = to;
    }
}
