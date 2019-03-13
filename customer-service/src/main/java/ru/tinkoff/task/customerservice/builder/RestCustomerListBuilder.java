package ru.tinkoff.task.customerservice.builder;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.tinkoff.task.customerservice.dto.DbCustomer;
import ru.tinkoff.task.customerservice.dto.RestCustomer;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class RestCustomerListBuilder {
    private final RestCustomerBuilder restCustomerBuilder;

    public List<RestCustomer> build(List<DbCustomer> dbCustomers) {
        List<RestCustomer> restCustomers = new ArrayList<>(dbCustomers.size());
        for (DbCustomer dbCustomer : dbCustomers)
            restCustomers.add(restCustomerBuilder.build(dbCustomer));
        return restCustomers;
    }
}