package com.onlinebankingsystem.service;



public interface UserService {
    UserDto getUserById(Long id);
    UserDto registerUser(UserDto userDto);
    UserDto updateUser(Long id, UserDto userDto);
    void deleteUser(Long id);
    String encodePassword(String password);
}
