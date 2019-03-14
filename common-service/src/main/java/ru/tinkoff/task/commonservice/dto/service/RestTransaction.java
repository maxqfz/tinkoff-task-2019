package ru.tinkoff.task.commonservice.dto.service;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RestTransaction {
    private RestAction action;
    private BigDecimal amount;
}