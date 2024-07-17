package com.onlinebankingsystem.controller;

import com.onlinebankingsystem.dto.AccountDTO;
import com.onlinebankingsystem.service.serviceImpl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/acc")
public class AccountController {

    @Autowired
    private AccountServiceImpl accountServiceImpl;

    @PostMapping("/create")
    public void createAccount(@RequestBody AccountDTO accountDTO){
        accountServiceImpl.createAccount(accountDTO);
    }

    @GetMapping("/get")
    public AccountDTO getAccountDetails(@PathVariable Long id){
       return accountServiceImpl.getAccountDetails(id);
    }


}
