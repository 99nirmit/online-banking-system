package com.onlinebankingsystem.service;

public interface TransactionalService {

    void transfer(Long fromAccountId, Long toAccountId, double amount);
}
