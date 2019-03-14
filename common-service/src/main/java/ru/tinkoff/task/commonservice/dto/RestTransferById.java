package ru.tinkoff.task.commonservice.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RestTransferById {
    private long fromAccount;
    private long toAccount;
    private BigDecimal amount;
}