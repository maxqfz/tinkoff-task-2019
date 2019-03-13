package ru.tinkoff.task.accountservice.logic;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.logging.LogLevel;
import org.springframework.stereotype.Component;
import ru.tinkoff.eclair.annotation.Log;
import ru.tinkoff.task.accountservice.builder.RestAccountBuilder;
import ru.tinkoff.task.accountservice.configuration.AccountRepository;
import ru.tinkoff.task.accountservice.dto.RestAccount;
import ru.tinkoff.task.accountservice.error.AccountNotFoundException;
import ru.tinkoff.task.accountservice.helper.ExceptionWrapper;

@Component
@RequiredArgsConstructor
public class GetAccountOperation {
    private final AccountRepository accountRepository;
    private final RestAccountBuilder restAccountBuilder;

    @Log(LogLevel.INFO)
    public RestAccount process(long id) {
        return ExceptionWrapper.wrap(() -> innerProcess(id));
    }

    private RestAccount innerProcess(long id) {
        return restAccountBuilder.build(
                accountRepository.findById(id).orElseThrow(
                        () -> new AccountNotFoundException(id)
                )
        );
    }
}