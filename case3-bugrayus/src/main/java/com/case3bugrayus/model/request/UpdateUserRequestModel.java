package com.case3bugrayus.model.request;

import com.case3bugrayus.model.UserType;
import lombok.Data;

@Data
public class UpdateUserRequestModel {
    Long id;
    String username;
    UserType userType;
}
