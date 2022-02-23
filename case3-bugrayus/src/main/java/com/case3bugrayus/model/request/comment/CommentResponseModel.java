package com.case3bugrayus.model.request.comment;

import com.case3bugrayus.model.Product;
import com.case3bugrayus.model.User;
import lombok.Data;

@Data
public class CommentResponseModel {
    Long id;
    User user;
    String comment;
    Product product;
}
