package ru.tinkoff.task.accountservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.math.BigDecimal;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestAccount {
    private long id;
    private String number;
    private long customerId;
    private BigDecimal money;
}