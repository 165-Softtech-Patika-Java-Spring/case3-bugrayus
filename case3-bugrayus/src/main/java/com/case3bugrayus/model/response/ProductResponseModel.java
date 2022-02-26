package com.case3bugrayus.model.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductResponseModel {
    Long id;
    String name;
    BigDecimal price;
}
