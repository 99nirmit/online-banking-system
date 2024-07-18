package com.onlinebankingsystem.repository;

import com.onlinebankingsystem.entities.Account;
import com.onlinebankingsystem.entities.BusinessAccount;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AccountRepositoryTest {

    @Mock
    private AccountRepository accountRepository;

    @Test
    void saveAndFindByIdTest(){
        BusinessAccount businessAccount = new BusinessAccount();
        businessAccount.setTypeOfAccount("Business Account");
        businessAccount.setBalance(500.0);
        businessAccount.setId(1L);

        // Mock the repository to return the account when saved
        when(accountRepository.save(any(BusinessAccount.class))).thenReturn(businessAccount);
        when(accountRepository.findById(anyLong())).thenReturn(Optional.of(businessAccount));

        Account savedAccount = accountRepository.save(businessAccount);

        //Assert
        assertNotNull(savedAccount);
        assertEquals(500.0, savedAccount.getBalance());
        assertEquals("Business Account", savedAccount.getTypeOfAccount());

        //Assert and Retrive Id
        Optional<Account> foundAccount = accountRepository.findById(1L);
        assertTrue(foundAccount.isPresent());

        //verify
        verify(accountRepository, times(1)).save(any(BusinessAccount.class));
        verify(accountRepository, times(1)).findById(anyLong());
    }

}