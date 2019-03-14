package ru.tinkoff.task.commonservice.builder;

import org.springframework.stereotype.Component;
import ru.tinkoff.task.commonservice.dto.RestCustomerWithAccounts;
import ru.tinkoff.task.commonservice.dto.service.RestAccount;
import ru.tinkoff.task.commonservice.dto.service.RestCustomer;

import java.util.ArrayList;
import java.util.List;

@Component
public class RestCustomerWithAccountsBuilder {
    public RestCustomerWithAccounts build(RestCustomer restCustomer, List<RestAccount> restAccounts) {
        RestCustomerWithAccounts restCustomerWithAccounts = new RestCustomerWithAccounts();
        restCustomerWithAccounts.setData(restCustomer);
        restCustomerWithAccounts.setAccounts(new ArrayList<>(restAccounts.size()));
        restCustomerWithAccounts.getAccounts().addAll(restAccounts);
        return restCustomerWithAccounts;
    }
}