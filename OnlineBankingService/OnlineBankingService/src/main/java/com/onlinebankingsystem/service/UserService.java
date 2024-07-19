package com.onlinebankingsystem.service;


import com.onlinebankingsystem.dto.UserDto;

public interface UserService {
    UserDto getUserById(Long id);
    UserDto registerUser(UserDto userDto);
    UserDto updateUser(Long id, UserDto userDto);
    void deleteUser(Long id);
}
