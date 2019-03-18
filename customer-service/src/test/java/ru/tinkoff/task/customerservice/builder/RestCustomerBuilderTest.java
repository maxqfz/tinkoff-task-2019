package ru.tinkoff.task.customerservice.builder;

import org.junit.jupiter.api.Test;
import ru.tinkoff.task.customerservice.dto.DbCustomer;
import ru.tinkoff.task.customerservice.dto.RestCustomer;

import java.math.BigInteger;
import java.sql.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RestCustomerBuilderTest {
    private final RestCustomerBuilder restCustomerBuilder = new RestCustomerBuilder();

    @Test
    public void builderTest() {
        //given
        DbCustomer dbCustomer = givenDbCustomer();
        //when
        RestCustomer restCustomer =  restCustomerBuilder.build(dbCustomer);
        //then
        thenRestCustomer(restCustomer);
    }

    private DbCustomer givenDbCustomer() {
        DbCustomer dbCustomer = new DbCustomer();
        dbCustomer.setId(1);
        dbCustomer.setFirstName("firstName");
        dbCustomer.setLastName("lastName");
        dbCustomer.setEmail("email");
        dbCustomer.setPhone(new BigInteger("79001234567"));
        dbCustomer.setBirthDate(Date.valueOf("2018-02-20"));
        return dbCustomer;
    }

    private void thenRestCustomer(RestCustomer restCustomer) {
        assertEquals(restCustomer.getId(), 1);
        assertThat(restCustomer.getFirstName()).contains("firstName");
        assertThat(restCustomer.getLastName()).contains("lastName");
        assertThat(restCustomer.getEmail()).contains("email");
        assertThat(restCustomer.getPhone()).contains("79001234567");
        assertThat(restCustomer.getBirthDate()).contains("2018-02-20");
    }
}