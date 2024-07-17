package com.onlinebankingsystem.service;

import com.onlinebankingsystem.dto.AccountDTO;

public interface AccountService {

    void createAccount(AccountDTO accountDTO);

    AccountDTO getAccountDetails(Long id);

}
