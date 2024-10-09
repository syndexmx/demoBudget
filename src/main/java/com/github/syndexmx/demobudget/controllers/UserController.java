package com.github.syndexmx.demobudget.controllers;

import com.github.syndexmx.demobudget.domain.User;
import com.github.syndexmx.demobudget.domain.UserDto;
import com.github.syndexmx.demobudget.domain.UserEntity;
import com.github.syndexmx.demobudget.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PutMapping(path = "/users/{userName}")
    public ResponseEntity<UserDto> createUser(
            @PathVariable final String userName,
            @RequestBody UserDto userDto) {
        User user = UserDtoToUser(userDto);
        user.setUserName(userName);
        // TO DO Check if already exists
        final User savedUser = userService.create(user);
        final ResponseEntity response = new ResponseEntity(UserToUserDto(user), HttpStatus.CREATED);
        return response;
    }

    private UserDto UserToUserDto(User user) {
        return UserDto.builder()
                .userName(user.getUserName())
                .email(user.getEmail())
                .build();
    }

    private User UserDtoToUser(UserDto userDto) {
        return User.builder()
                .userName(userDto.getUserName())
                .email(userDto.getEmail())
                .build();
    }
}
