package com.onlinebankingsystem.controller;

import com.onlinebankingsystem.dto.UserDTO;
import com.onlinebankingsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public UserDTO registerUser(@RequestBody UserDTO userDTO) {
        return userService.registerUser(userDTO);
    }

    @PostMapping("/login")
    public UserDTO loginUser(@RequestParam String username, @RequestParam String password) {
        return userService.loginUser(username, password);
    }
}
