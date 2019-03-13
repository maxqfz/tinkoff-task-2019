package ru.tinkoff.task.accountservice.logic;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.logging.LogLevel;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.tinkoff.eclair.annotation.Log;
import ru.tinkoff.task.accountservice.configuration.AccountRepository;
import ru.tinkoff.task.accountservice.helper.ExceptionWrapper;

@Component
@RequiredArgsConstructor
public class DeleteAccountOperation {
    private final AccountRepository accountRepository;

    @Log(LogLevel.INFO)
    @Transactional
    public void process(long id) {
        ExceptionWrapper.wrap(() -> {
            innerProcess(id);
            return null;
        });
    }

    private void innerProcess(long id) {
        accountRepository.deleteById(id);
    }
}