package com.onlinebankingsystem.repository;

import com.onlinebankingsystem.dto.UserDTO;
import com.onlinebankingsystem.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
