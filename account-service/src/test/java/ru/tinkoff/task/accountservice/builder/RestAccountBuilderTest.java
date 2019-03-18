package ru.tinkoff.task.accountservice.builder;

import org.junit.jupiter.api.Test;
import ru.tinkoff.task.accountservice.dto.DbAccount;
import ru.tinkoff.task.accountservice.dto.RestAccount;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class RestAccountBuilderTest {
    private RestAccountBuilder restAccountBuilder = new RestAccountBuilder();

    @Test
    public void builderTest() {
        //given
        DbAccount dbAccount = givenDbAccount();
        //when
        RestAccount restAccount = restAccountBuilder.build(dbAccount);
        //then
        thenRestAccount(restAccount);
    }

    private DbAccount givenDbAccount() {
        DbAccount dbAccount = new DbAccount();
        dbAccount.setId(0);
        dbAccount.setCustomerId(0);
        dbAccount.setNumber("number");
        dbAccount.setMoney(new BigDecimal("123.45"));
        return dbAccount;
    }

    private void thenRestAccount(RestAccount restAccount) {
        assertThat(restAccount.getId()).isEqualTo(0);
        assertThat(restAccount.getCustomerId()).isEqualTo(0);
        assertThat(restAccount.getNumber()).isEqualTo("number");
        assertThat(restAccount.getMoney()).isEqualTo("123.45");
    }
}
