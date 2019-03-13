package ru.tinkoff.task.accountservice.logic;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.logging.LogLevel;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.tinkoff.eclair.annotation.Log;
import ru.tinkoff.task.accountservice.builder.RestAccountBuilder;
import ru.tinkoff.task.accountservice.configuration.AccountRepository;
import ru.tinkoff.task.accountservice.dto.DbAccount;
import ru.tinkoff.task.accountservice.dto.RestAccount;
import ru.tinkoff.task.accountservice.dto.RestTransaction;
import ru.tinkoff.task.accountservice.error.AccountNotFoundException;
import ru.tinkoff.task.accountservice.error.NotEnoughMoneyException;
import ru.tinkoff.task.accountservice.helper.ExceptionWrapper;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class TransactionByIdOperation {
    private final AccountRepository accountRepository;
    private final RestAccountBuilder restAccountBuilder;

    @Log(LogLevel.INFO)
    @Transactional
    public RestAccount process(long id, RestTransaction restTransaction) {
        return ExceptionWrapper.wrap(() -> innerProcess(id, restTransaction));
    }

    private RestAccount innerProcess(long id, RestTransaction restTransaction) {
        DbAccount account = accountRepository.findById(id).orElseThrow(
                () -> new AccountNotFoundException(id)
        );

        switch (restTransaction.getAction()) {
            case DEPOSIT:
                account.setMoney(account.getMoney().add(restTransaction.getAmount()));
                break;
            case WITHDRAW:
                BigDecimal newMoney = account.getMoney().subtract(restTransaction.getAmount());
                if(newMoney.compareTo(BigDecimal.ZERO) < 0)
                    throw new NotEnoughMoneyException();
                account.setMoney(newMoney);
        }

        return restAccountBuilder.build(
                accountRepository.save(account)
        );
    }
}