package ru.tinkoff.task.commonservice.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RestTransferByNumber {
    private String fromAccount;
    private String toAccount;
    private BigDecimal amount;
}