package ru.tinkoff.task.commonservice.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RestTransfer {
    private String fromAccount;
    private String toAccount;
    private BigDecimal amount;
}
