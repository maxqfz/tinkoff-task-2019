package ru.tinkoff.task.commonservice.logic;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.logging.LogLevel;
import org.springframework.stereotype.Component;
import ru.tinkoff.eclair.annotation.Log;
import ru.tinkoff.task.commonservice.builder.RestCustomerWithAccountsBuilder;
import ru.tinkoff.task.commonservice.dto.RestCustomerWithAccounts;
import ru.tinkoff.task.commonservice.helper.ExceptionWrapper;
import ru.tinkoff.task.commonservice.service.rest.AccountServiceClientAdapter;
import ru.tinkoff.task.commonservice.service.rest.CustomerServiceClientAdapter;

@Component
@RequiredArgsConstructor
public class GetCustomerWithAccountsOperation {
    private final AccountServiceClientAdapter accountServiceClientAdapter;
    private final CustomerServiceClientAdapter customerServiceClientAdapter;
    private final RestCustomerWithAccountsBuilder restCustomerWithAccountsBuilder;

    @Log(LogLevel.INFO)
    public RestCustomerWithAccounts process(long id) {
        return ExceptionWrapper.wrap(() -> innerProcess(id));
    }

    private RestCustomerWithAccounts innerProcess(long id) {
        return restCustomerWithAccountsBuilder.build(
                customerServiceClientAdapter.getCustomer(id),
                accountServiceClientAdapter.getAccountsByCustomer(id)
        );
    }
}
