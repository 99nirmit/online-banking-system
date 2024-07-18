package com.onlinebankingsystem.entities;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class SavingAccount extends Account{

    public SavingAccount(double initialBalance){
        super();
        this.setTypeOfAccount("Saving Account");
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
