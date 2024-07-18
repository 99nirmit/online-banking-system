package com.onlinebankingsystem.service.serviceImpl;

import com.onlinebankingsystem.entities.Account;
import com.onlinebankingsystem.entities.BusinessAccount;
import com.onlinebankingsystem.entities.SavingAccount;
import com.onlinebankingsystem.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TransactionalServiceImplTest {

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private TransactionalServiceImpl transactionalServiceImpl;

    void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void transferMoney(){

        Account fromAccount = new BusinessAccount(1000.0);
        fromAccount.setId(2L);

        Account toAccount = new SavingAccount(500.0);
        toAccount.setId(1L);

        // Mock repository behavior
        when(accountRepository.findById(2L)).thenReturn(Optional.of(fromAccount));
        when(accountRepository.findById(1L)).thenReturn(Optional.of(toAccount));

        // Execute the method to be tested
        transactionalServiceImpl.transfer(2L, 1L, 200);

        verify(accountRepository, times(1)).findById(2L);
        verify(accountRepository, times(1)).findById(1L);
        verify(accountRepository, times(1)).save(fromAccount);
        verify(accountRepository, times(1)).save(toAccount);

        assertEquals(800.0, fromAccount.getBalance());
        assertEquals(700.0, toAccount.getBalance());
    }

    @Test
    void insufficientBalance(){

        Account fromAccount = new BusinessAccount(100.0);
        fromAccount.setId(2L);

        Account toAccount = new BusinessAccount(300.0);
        toAccount.setId(1L);

        when(accountRepository.findById(2L)).thenReturn(Optional.of(fromAccount));
        when(accountRepository.findById(1L)).thenReturn(Optional.of(toAccount));

        Exception exception = assertThrows(RuntimeException.class, () -> {
            transactionalServiceImpl.transfer(2L,1L,500.0);
        });

        assertEquals("Insufficient Funds in Account",exception.getMessage());

        verify(accountRepository, times(1)).findById(2L);
        verify(accountRepository, times(1)).findById(1L);
        verify(accountRepository, never()).save(fromAccount);
        verify(accountRepository, never()).save(toAccount);

    }

}