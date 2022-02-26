package com.case3bugrayus.model.response;

import com.case3bugrayus.model.UserType;
import lombok.Data;

@Data
public class UserResponseModel {
    Long id;
    String username;
    String phone;
    String mail;
    UserType userType;
}
