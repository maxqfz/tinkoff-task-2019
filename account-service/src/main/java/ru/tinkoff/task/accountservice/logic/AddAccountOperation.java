package ru.tinkoff.task.accountservice.logic;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.logging.LogLevel;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.tinkoff.eclair.annotation.Log;
import ru.tinkoff.task.accountservice.builder.DbAccountBuilder;
import ru.tinkoff.task.accountservice.builder.RestAccountBuilder;
import ru.tinkoff.task.accountservice.dto.RestAccount;
import ru.tinkoff.task.accountservice.error.NoClientSpecifiedException;
import ru.tinkoff.task.accountservice.helper.ExceptionWrapper;
import ru.tinkoff.task.accountservice.configuration.AccountRepository;

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
        if(restAccount.getClientId() == 0)
            throw new NoClientSpecifiedException();
        return restAccountBuilder.build(
                accountRepository.save(
                        dbAccountBuilder.build(restAccount)
                )
        );
    }
}