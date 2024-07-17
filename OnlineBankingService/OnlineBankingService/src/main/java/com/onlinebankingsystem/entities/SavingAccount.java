package com.onlinebankingsystem.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class SavingAccount extends Account{

    public SavingAccount(){
        super();
    }

    public SavingAccount(double initialBalance){
        super();
        // Use setter method to initialize balance
        this.setBalance(initialBalance);
    }
    //    Use setter method to update balance
    @Override
    public void deposit(double amount) {
        setBalance(getBalance()  + amount);
    }

    @Override
    public void withdraw(double amount) {
        setBalance(getBalance() - amount);
    }

}
