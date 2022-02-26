package com.case3bugrayus.model.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Data
public class CreateProductRequestModel {
    @NotBlank
    String name;
    BigDecimal price;
}
