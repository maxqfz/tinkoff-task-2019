package ru.tinkoff.task.accountservice.builder;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.tinkoff.task.accountservice.dto.DbAccount;
import ru.tinkoff.task.accountservice.dto.RestAccount;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class RestAccountListBuilder {
    private final RestAccountBuilder restAccountBuilder;

    public List<RestAccount> build(List<DbAccount> dbAccounts) {
        List<RestAccount> restAccounts = new ArrayList<>(dbAccounts.size());
        for (DbAccount dbAccount : dbAccounts)
            restAccounts.add(restAccountBuilder.build(dbAccount));
        return restAccounts;
    }
}
