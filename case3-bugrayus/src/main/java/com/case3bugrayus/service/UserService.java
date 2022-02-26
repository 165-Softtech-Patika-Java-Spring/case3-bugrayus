package com.case3bugrayus.service;

import com.case3bugrayus.model.User;
import com.case3bugrayus.model.request.CreateUserRequestModel;
import com.case3bugrayus.model.request.DeleteUserRequestModel;
import com.case3bugrayus.model.request.UpdateUserRequestModel;
import com.case3bugrayus.model.response.UserResponseModel;
import com.case3bugrayus.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper mapper;

    public UserResponseModel getUser(long id) {
        if (!userRepository.existsById(id))
            return null;
        return mapper.map(userRepository.getById(id), UserResponseModel.class);
    }

    public UserResponseModel getUser(String username) {
        if (!userRepository.existsByUsername(username))
            return null;
        return mapper.map(userRepository.findByUsername(username), UserResponseModel.class);
    }

    public List<UserResponseModel> getUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(x -> mapper.map(x, UserResponseModel.class)).collect(Collectors.toList());
    }

    public boolean createUser(CreateUserRequestModel requestModel) {
        if (userRepository.existsByUsernameOrPhone(requestModel.getUsername(), requestModel.getPhone()))
            throw new ResponseStatusException(HttpStatus.CONFLICT, "User already exists by that name or phone.");
        mapper.getConfiguration().setAmbiguityIgnored(true);
        userRepository.save(mapper.map(requestModel, User.class));
        return true;
    }

    public boolean deleteUser(DeleteUserRequestModel requestModel) {
        if (!userRepository.existsByUsernameAndPhone(requestModel.getUsername(), requestModel.getPhone()))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, requestModel.getUsername() + " Does not match with " + requestModel.getPhone() + " phone number");
        userRepository.delete(userRepository.findByUsernameAndPhone(requestModel.getUsername(), requestModel.getPhone()));
        return true;
    }

    public boolean updateUser(UpdateUserRequestModel requestModel) {
        if (!userRepository.existsById(requestModel.getId()))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found by that id");
        User user = userRepository.getById(requestModel.getId());
        mapper.map(requestModel, user);
        userRepository.save(user);
        return true;
    }
}
