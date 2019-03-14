package ru.tinkoff.task.commonservice.service.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.logging.LogLevel;
import org.springframework.stereotype.Component;
import ru.tinkoff.eclair.annotation.Log;
import ru.tinkoff.task.commonservice.dto.service.RestAccount;
import ru.tinkoff.task.commonservice.dto.service.RestTransaction;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AccountServiceClientAdapter {
    private final AccountServiceClient accountServiceClient;

    @Log(LogLevel.DEBUG)
    public List<RestAccount> getAccountsByCustomer(long customerId) {
        return accountServiceClient.getCustomerAccounts(customerId);
    }

    @Log(LogLevel.DEBUG)
    public RestAccount makeTransactionById(long id, RestTransaction transaction) {
        return accountServiceClient.makeTransactionById(id, transaction);
    }

    @Log(LogLevel.DEBUG)
    public RestAccount makeTransactionByNumber(String number, RestTransaction transaction) {
        return accountServiceClient.makeTransactionByNumber(number, transaction);
    }
}
