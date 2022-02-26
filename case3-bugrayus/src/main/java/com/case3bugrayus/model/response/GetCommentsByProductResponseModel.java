package com.case3bugrayus.model.response;

import com.case3bugrayus.model.User;
import lombok.Data;

@Data
public class GetCommentsByProductResponseModel {
    Long id;
    User user;
    String comment;
}
