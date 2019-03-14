package ru.tinkoff.task.commonservice.dto.service;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.math.BigDecimal;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestAccount {
    private long id;
    private String number;
    private long clientId;
    private BigDecimal money;
}