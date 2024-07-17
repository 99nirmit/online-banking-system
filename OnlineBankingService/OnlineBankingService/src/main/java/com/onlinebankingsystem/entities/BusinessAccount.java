package com.onlinebankingsystem.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BusinessAccount extends Account{

    public BusinessAccount(){
        super();
    }

    public BusinessAccount(double initialBalance){
        super();
        this.setBalance(initialBalance);
    }

    @Override
    public void deposit(double amount) {
        setBalance(getBalance() + amount);
    }

    @Override
    public void withdraw(double amount) {
        setBalance(getBalance() - amount);
    }
}
