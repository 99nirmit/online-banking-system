package com.onlinebankingsystem.service;

import com.onlinebankingsystem.dto.UserDTO;

public interface UserService {
    UserDTO registerUser(UserDTO userDTO);
    UserDTO loginUser(String username, String password);
}
