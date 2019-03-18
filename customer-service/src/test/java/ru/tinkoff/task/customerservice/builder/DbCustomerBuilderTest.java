package ru.tinkoff.task.customerservice.builder;

import org.junit.jupiter.api.Test;
import ru.tinkoff.task.customerservice.dto.DbCustomer;
import ru.tinkoff.task.customerservice.dto.RestCustomer;

import java.sql.Date;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class DbCustomerBuilderTest {
    private final DbCustomerBuilder dbCustomerBuilder = new DbCustomerBuilder();

    @Test
    public void builderTest() {
        //given
        RestCustomer restCustomer = givenRestCustomer();
        //when
        DbCustomer dbCustomer = dbCustomerBuilder.build(restCustomer);
        //then
        thenDbCustomer(dbCustomer);
    }

    private RestCustomer givenRestCustomer() {
        RestCustomer restCustomer = new RestCustomer();
        restCustomer.setFirstName("firstName");
        restCustomer.setLastName("lastName");
        restCustomer.setEmail("email");
        restCustomer.setPhone("+7 (900) 123-45-67");
        restCustomer.setBirthDate("2018-02-20");
        return restCustomer;
    }

    private void thenDbCustomer(DbCustomer dbCustomer) {
        assertThat(dbCustomer.getFirstName()).contains("firstName");
        assertThat(dbCustomer.getLastName()).contains("lastName");
        assertThat(dbCustomer.getEmail()).contains("email");
        assertThat(dbCustomer.getPhone().toString()).contains("79001234567");
        thenBirthDate(dbCustomer.getBirthDate());
    }

    private void thenBirthDate(Date birthDate) {
        LocalDate date = birthDate.toLocalDate();
        assertThat(date.getDayOfMonth()).isEqualTo(20);
        assertThat(date.getMonthValue()).isEqualTo(2);
        assertThat(date.getYear()).isEqualTo(2018);
    }
}