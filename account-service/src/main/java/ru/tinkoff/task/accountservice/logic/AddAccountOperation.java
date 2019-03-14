package ru.tinkoff.task.accountservice.logic;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.logging.LogLevel;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.tinkoff.eclair.annotation.Log;
import ru.tinkoff.task.accountservice.builder.DbAccountBuilder;
import ru.tinkoff.task.accountservice.builder.RestAccountBuilder;
import ru.tinkoff.task.accountservice.configuration.AccountRepository;
import ru.tinkoff.task.accountservice.dto.RestAccount;
import ru.tinkoff.task.accountservice.error.NoCustomerSpecifiedException;
import ru.tinkoff.task.accountservice.helper.ExceptionWrapper;

@Component
@RequiredArgsConstructor
public class AddAccountOperation {
    private final AccountRepository accountRepository;
    private final DbAccountBuilder dbAccountBuilder;
    private final RestAccountBuilder restAccountBuilder;

    @Log(LogLevel.INFO)
    @Transactional
    public RestAccount process(RestAccount restAccount) {
        return ExceptionWrapper.wrap(() -> innerProcess(restAccount));
    }

    private RestAccount innerProcess(RestAccount restAccount) {
        if (restAccount.getCustomerId() == 0)
            throw new NoCustomerSpecifiedException();
        return restAccountBuilder.build(
                accountRepository.save(
                        dbAccountBuilder.build(restAccount)
                )
        );
    }
}