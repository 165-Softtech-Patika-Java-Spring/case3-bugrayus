package com.case3bugrayus.model.request.product;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateProductRequestModel {
    String name;
    BigDecimal price;
}
