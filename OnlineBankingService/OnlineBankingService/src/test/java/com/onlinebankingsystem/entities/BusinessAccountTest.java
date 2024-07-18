package com.onlinebankingsystem.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class BusinessAccountTest {

    private BusinessAccount businessAccount;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
        businessAccount = new BusinessAccount(1000.0);
    }

    @Test
    void testDeposit(){
        businessAccount.deposit(200.0);
        assertEquals(1200.0, businessAccount.getBalance());
    }

    @Test
    void testWithdraw(){
        businessAccount.withdraw(300.0);
        assertEquals(700.0, businessAccount.getBalance());
    }


}