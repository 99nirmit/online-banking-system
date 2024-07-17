package com.onlinebankingsystem.controller;

import com.onlinebankingsystem.service.serviceImpl.TransactionalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/acc")
public class TransactionController {

    @Autowired
    private TransactionalServiceImpl transactionalService;

    public ResponseEntity<String> transfer(@RequestParam Long fromAccountId, @RequestParam Long toAccountId, double amount){
        try{
            transactionalService.transfer(fromAccountId, toAccountId,amount);
            return new ResponseEntity<>("Transfer Succesfull", HttpStatus.OK);
        }catch (RuntimeException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
