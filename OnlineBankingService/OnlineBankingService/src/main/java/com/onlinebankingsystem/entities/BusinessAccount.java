package com.onlinebankingsystem.entities;

import jakarta.persistence.Entity;
import jdk.jfr.Enabled;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class BusinessAccount extends Account{

    public BusinessAccount(){
        super();
        this.setTypeOfAccount("Business Account");
    }

    public BusinessAccount(double initialBalance){
        super();
        this.setTypeOfAccount("Business Account");
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
