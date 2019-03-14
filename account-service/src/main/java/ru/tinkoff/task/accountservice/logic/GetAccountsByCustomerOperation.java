package ru.tinkoff.task.accountservice.logic;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.logging.LogLevel;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import ru.tinkoff.eclair.annotation.Log;
import ru.tinkoff.task.accountservice.builder.RestAccountListBuilder;
import ru.tinkoff.task.accountservice.configuration.AccountRepository;
import ru.tinkoff.task.accountservice.dto.RestAccount;
import ru.tinkoff.task.accountservice.helper.ExceptionWrapper;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetAccountsByCustomerOperation {
    private final AccountRepository accountRepository;
    private final RestAccountListBuilder restAccountListBuilder;

    @Log(LogLevel.INFO)
    public List<RestAccount> process(long customerId) {
        return ExceptionWrapper.wrap(() -> innerProcess(customerId));
    }

    private List<RestAccount> innerProcess(long customerId) {
        //TODO: What if customer has more than 10 accounts?
        return restAccountListBuilder.build(
                accountRepository.findByCustomerId(customerId, PageRequest.of(0, 10)).getContent()
        );
    }
}