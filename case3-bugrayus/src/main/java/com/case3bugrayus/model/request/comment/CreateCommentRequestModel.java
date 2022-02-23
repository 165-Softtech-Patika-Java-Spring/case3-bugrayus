package com.case3bugrayus.model.request.comment;

import lombok.Data;

@Data
public class CreateCommentRequestModel {
    int userId;
    int commentId;
    int productId;
}
