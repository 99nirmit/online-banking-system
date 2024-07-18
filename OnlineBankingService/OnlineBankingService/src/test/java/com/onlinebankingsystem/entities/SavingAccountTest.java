package com.onlinebankingsystem.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class SavingAccountTest {

    private SavingAccount savingAccount;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        savingAccount = new SavingAccount(2000.0);
    }

    @Test
    void testDeposit(){
        savingAccount.deposit(100.0);
        assertEquals(2100.0, savingAccount.getBalance());
    }

    @Test
    void testWithdraw(){
        savingAccount.withdraw(200.0);
        assertEquals(1800.0, savingAccount.getBalance());
    }

}