package ru.tinkoff.task.accountservice.logic;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.logging.LogLevel;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
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
public class TransactionByNumberOperation {
    private final AccountRepository accountRepository;
    private final RestAccountBuilder restAccountBuilder;

    @Log(LogLevel.INFO)
    public RestAccount process(String number, RestTransaction restTransaction) {
        return ExceptionWrapper.wrap(() -> innerProcess(number, restTransaction));
    }

    private RestAccount innerProcess(String number, RestTransaction restTransaction) {
        DbAccount account = accountRepository.findByNumber(number,
                PageRequest.of(0, 1)).stream().findFirst().orElseThrow(
                () -> new AccountNotFoundException(number)
        );

        //TODO: combine with TransactionById

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