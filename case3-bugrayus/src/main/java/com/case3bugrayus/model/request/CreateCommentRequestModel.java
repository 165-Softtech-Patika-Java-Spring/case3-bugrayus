package com.case3bugrayus.model.request;

import lombok.Data;

@Data
public class CreateCommentRequestModel {
    int userId;
    String comment;
    int productId;
}
