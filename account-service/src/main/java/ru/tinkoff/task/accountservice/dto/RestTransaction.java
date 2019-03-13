package ru.tinkoff.task.accountservice.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RestTransaction {
    private RestAction action;
    private BigDecimal amount;
}