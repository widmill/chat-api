package com.example.chatapi.controller;

import com.example.chatapi.entity.User;
import com.example.chatapi.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public Long createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

}
