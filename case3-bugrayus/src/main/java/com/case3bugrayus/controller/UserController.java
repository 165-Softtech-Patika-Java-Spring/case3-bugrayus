package com.case3bugrayus.controller;

import com.case3bugrayus.model.request.CreateUserRequestModel;
import com.case3bugrayus.model.request.DeleteUserRequestModel;
import com.case3bugrayus.model.request.UpdateUserRequestModel;
import com.case3bugrayus.model.response.UserResponseModel;
import com.case3bugrayus.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/user/{id}")
    public UserResponseModel getUser(@PathVariable int id) {
        return userService.getUser(id);
    }

    @GetMapping("/user/{username}/username")
    public UserResponseModel getUser(@PathVariable String username) {
        return userService.getUser(username);
    }

    @GetMapping("/users")
    public List<UserResponseModel> getUsers() {
        return userService.getUsers();
    }

    @PostMapping("/user")
    public boolean createUser(@RequestBody CreateUserRequestModel requestModel) {
        return userService.createUser(requestModel);
    }

    @PutMapping("/user")
    public boolean updateUser(@RequestBody UpdateUserRequestModel requestModel) {
        return userService.updateUser(requestModel);
    }

    @DeleteMapping("/user")
    public boolean deleteUser(@RequestBody DeleteUserRequestModel requestModel) {
        return userService.deleteUser(requestModel);
    }
}
