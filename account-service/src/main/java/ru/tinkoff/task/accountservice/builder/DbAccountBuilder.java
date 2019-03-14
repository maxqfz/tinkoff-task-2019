package ru.tinkoff.task.accountservice.builder;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.tinkoff.task.accountservice.dto.DbAccount;
import ru.tinkoff.task.accountservice.dto.RestAccount;
import ru.tinkoff.task.accountservice.helper.AccountNumberGenerator;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class DbAccountBuilder {
    private final AccountNumberGenerator accountNumberGenerator;

    public DbAccount build(RestAccount restAccount) {
        DbAccount dbAccount = new DbAccount();
        dbAccount.setNumber(accountNumberGenerator.generate());
        dbAccount.setCustomerId(restAccount.getClientId());
        dbAccount.setMoney(new BigDecimal(0));
        return dbAccount;
    }
}