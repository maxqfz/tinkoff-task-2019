package ru.tinkoff.task.customerservice.builder;

import org.springframework.stereotype.Component;
import ru.tinkoff.task.customerservice.dto.DbCustomer;
import ru.tinkoff.task.customerservice.dto.RestCustomer;

import java.math.BigInteger;
import java.sql.Date;

@Component
public class DbCustomerBuilder {
    public DbCustomer build(RestCustomer restCustomer) {
        DbCustomer dbCustomer = new DbCustomer();
        dbCustomer.setFirstName(restCustomer.getFirstName());
        dbCustomer.setLastName(restCustomer.getLastName());
        dbCustomer.setEmail(restCustomer.getEmail());
        if (restCustomer.getPhone() != null)
            dbCustomer.setPhone(parsePhone(restCustomer.getPhone()));
        if (restCustomer.getBirthDate() != null)
            dbCustomer.setBirthDate(Date.valueOf(restCustomer.getBirthDate()));
        return dbCustomer;
    }

    public DbCustomer build(long id, RestCustomer restCustomer) {
        DbCustomer dbCustomer = build(restCustomer);
        dbCustomer.setId(id);
        return dbCustomer;
    }

    private BigInteger parsePhone(String phone) {
        //Remove all non-numeric chars
        phone = phone.replaceAll("[^\\d.]", "");

        //Convert to international format
        phone = phone.replaceAll("^8", "7");

        return new BigInteger(phone);
    }
}