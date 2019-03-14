package ru.tinkoff.task.commonservice.dto;

import lombok.Data;
import ru.tinkoff.task.commonservice.dto.service.RestAccount;
import ru.tinkoff.task.commonservice.dto.service.RestCustomer;

import java.util.List;

@Data
public class RestCustomerWithAccounts {
    private RestCustomer data;
    private List<RestAccount> accounts;
}