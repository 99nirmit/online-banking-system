package com.onlinebankingsystem.service.serviceImpl;

import com.onlinebankingsystem.dto.AccountDTO;
import com.onlinebankingsystem.entities.Account;
import com.onlinebankingsystem.entities.BusinessAccount;
import com.onlinebankingsystem.entities.SavingAccount;
import com.onlinebankingsystem.repository.AccountRepository;
import com.onlinebankingsystem.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void createAccount(AccountDTO accountDTO) {
        Account account;
        if("Saving Account".equalsIgnoreCase(accountDTO.getTypeOfAccount())){
            account = new SavingAccount(accountDTO.getBalance());
        }else{
            account = new BusinessAccount(accountDTO.getBalance());
        }
        accountRepository.save(account);
    }

    @Override
    public AccountDTO getAccountDetails(Long id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account Not Found"));
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setId(account.getId());
        accountDTO.setBalance(account.getBalance());
        accountDTO.setTypeOfAccount(account.getTypeOfAccount());
        return accountDTO;
    }
}
