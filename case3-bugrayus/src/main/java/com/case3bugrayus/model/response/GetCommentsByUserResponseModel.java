package com.case3bugrayus.model.response;

import com.case3bugrayus.model.Product;
import lombok.Data;

@Data
public class GetCommentsByUserResponseModel {
    Long id;
    String comment;
    Product product;
}
