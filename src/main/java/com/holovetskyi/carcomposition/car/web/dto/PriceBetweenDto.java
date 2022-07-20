package com.holovetskyi.carcomposition.car.web.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PriceBetweenDto {

    String bodyType;
    BigDecimal from;
    BigDecimal to;


    public PriceBetweenDto(String bodyType, BigDecimal from, BigDecimal to) {
        this.bodyType = bodyType;
        this.from = from;
        this.to = to;

    }
}
