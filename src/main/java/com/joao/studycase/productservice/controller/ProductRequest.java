package com.joao.studycase.productservice.controller;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ProductRequest {

    private String title;
    private BigDecimal price;
    private Integer quantity;
}
