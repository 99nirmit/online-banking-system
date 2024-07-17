package com.onlinebankingsystem.controller;

import com.onlinebankingsystem.dto.TransferDTO;
import com.onlinebankingsystem.service.serviceImpl.TransactionalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/acc")
public class TransactionController {

    @Autowired
    private TransactionalServiceImpl transactionalService;

    @PostMapping("/transfer")
    public ResponseEntity<String> transfer(@RequestBody TransferDTO transferDTO){
        try{
            transactionalService.transfer(transferDTO.getFromAccountId(), transferDTO.getToAccountId(), transferDTO.getAmount());
            return new ResponseEntity<>("Transfer Succesfull", HttpStatus.OK);
        }catch (RuntimeException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
