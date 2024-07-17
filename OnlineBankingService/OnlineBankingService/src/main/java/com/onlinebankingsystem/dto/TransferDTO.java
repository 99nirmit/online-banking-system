package com.onlinebankingsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransferDTO {

    private Long fromAccountId;

    private Long toAccountId;

    private double amount;
}
