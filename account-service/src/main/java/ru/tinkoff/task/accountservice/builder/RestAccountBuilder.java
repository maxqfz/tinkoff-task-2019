package ru.tinkoff.task.accountservice.builder;

import org.springframework.stereotype.Component;
import ru.tinkoff.task.accountservice.dto.DbAccount;
import ru.tinkoff.task.accountservice.dto.RestAccount;

@Component
public class RestAccountBuilder {
    public RestAccount build(DbAccount dbAccount) {
        RestAccount restAccount = new RestAccount();
        restAccount.setId(dbAccount.getId());
        restAccount.setNumber(dbAccount.getNumber());
        restAccount.setClientId(dbAccount.getCustomerId());
        restAccount.setMoney(dbAccount.getMoney());
        return restAccount;
    }
}
