package ru.tinkoff.task.commonservice.service.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.tinkoff.eclair.annotation.Log;
import ru.tinkoff.task.commonservice.dto.service.RestAccount;

import java.util.List;

import static org.springframework.boot.logging.LogLevel.DEBUG;

@Component
@RequiredArgsConstructor
public class AccountServiceClientAdapter {
    private final AccountServiceClient accountServiceClient;

    @Log(DEBUG)
    public List<RestAccount> getAccountsByCustomer(long customerId) {
        return accountServiceClient.getCustomerAccounts(customerId);
    }
}
