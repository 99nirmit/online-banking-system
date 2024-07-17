package com.onlinebankingsystem.repository;

import com.onlinebankingsystem.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
