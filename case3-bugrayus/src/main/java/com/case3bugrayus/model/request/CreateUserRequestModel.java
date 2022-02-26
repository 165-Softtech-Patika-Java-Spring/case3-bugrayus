package com.case3bugrayus.model.request;

import com.case3bugrayus.model.UserType;
import lombok.Data;

@Data
public class CreateUserRequestModel {
    String username;
    String phone;
    String mail;
    UserType userType;
}
