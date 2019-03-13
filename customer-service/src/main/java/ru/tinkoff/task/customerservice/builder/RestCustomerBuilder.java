package ru.tinkoff.task.customerservice.builder;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.tinkoff.task.customerservice.dto.DbCustomer;
import ru.tinkoff.task.customerservice.dto.RestCustomer;

@Component
@RequiredArgsConstructor
public class RestCustomerBuilder {
    public RestCustomer build(DbCustomer dbCustomer) {
        RestCustomer restCustomer = new RestCustomer();
        restCustomer.setId(dbCustomer.getId());
        restCustomer.setFirstName(dbCustomer.getFirstName());
        restCustomer.setLastName(dbCustomer.getLastName());
        restCustomer.setEmail(dbCustomer.getEmail());
        if (restCustomer.getPhone() != null)
            restCustomer.setPhone(dbCustomer.getPhone().toString());
        if (restCustomer.getBirthDate() != null)
            restCustomer.setBirthDate(dbCustomer.getBirthDate().toString());
        return restCustomer;
    }
}