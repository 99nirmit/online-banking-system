package com.onlinebankingsystem.service.serviceImpl;

import com.onlinebankingsystem.entities.Account;
import com.onlinebankingsystem.repository.AccountRepository;
import com.onlinebankingsystem.service.TransactionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionalServiceImpl implements TransactionalService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void transfer(Long fromAccountId, Long toAccountId, double amount) {

     Account fromAccount = accountRepository.findById(fromAccountId)
             .orElseThrow(() -> new RuntimeException("Account Not Found"));

     Account toAccount = accountRepository.findById(toAccountId)
             .orElseThrow(() -> new RuntimeException("Account Not Found"));

     if(fromAccount.getBalance() < amount){
         throw  new RuntimeException("Insufficient Funds in Account");
     }

     fromAccount.withdraw(amount);
     toAccount.deposit(amount);

     accountRepository.save(fromAccount);
     accountRepository.save(toAccount);
    }
}
