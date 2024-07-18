package com.onlinebankingsystem.service.serviceImpl;

import com.onlinebankingsystem.dto.AccountDTO;
import com.onlinebankingsystem.entities.BusinessAccount;
import com.onlinebankingsystem.entities.SavingAccount;
import com.onlinebankingsystem.repository.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AccountServiceImplTest {

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AccountServiceImpl accountServiceImpl;

    private AccountDTO accountDTO;

    @BeforeEach
    void setup(){
        accountDTO = new AccountDTO();
        accountDTO.setBalance(1000.0);
    }

    @Test
    void createAccountForSavingAccount(){
        accountDTO.setTypeOfAccount("Saving Account");

        accountServiceImpl.createAccount(accountDTO);

        verify(accountRepository, times(1)).save(any(SavingAccount.class));
    }

    @Test
    void createAccountForBusinessAccount(){
        accountDTO.setTypeOfAccount("Business Account");

        accountServiceImpl.createAccount(accountDTO);

        verify(accountRepository, times(1)).save(any(BusinessAccount.class));
    }
}