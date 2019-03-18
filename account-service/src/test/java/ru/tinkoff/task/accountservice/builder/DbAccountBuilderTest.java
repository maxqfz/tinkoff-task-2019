package ru.tinkoff.task.accountservice.builder;

import org.junit.jupiter.api.Test;
import ru.tinkoff.task.accountservice.dto.DbAccount;
import ru.tinkoff.task.accountservice.dto.RestAccount;
import ru.tinkoff.task.accountservice.helper.AccountNumberGenerator;

import static org.assertj.core.api.Assertions.assertThat;

public class DbAccountBuilderTest {
    private DbAccountBuilder dbAccountBuilder = new DbAccountBuilder(new AccountNumberGenerator());

    @Test
    public void builderTest() {
        //given
        RestAccount restAccount = givenRestAccount();
        //when
        DbAccount dbAccount = dbAccountBuilder.build(restAccount);
        //then
        thenDbAccount(dbAccount);
    }

    private RestAccount givenRestAccount() {
        RestAccount restAccount = new RestAccount();
        restAccount.setCustomerId(0);
        return restAccount;
    }

    private void thenDbAccount(DbAccount dbAccount) {
        assertThat(dbAccount.getNumber()).isNotNull();
        assertThat(dbAccount.getCustomerId()).isEqualTo(0);
        assertThat(dbAccount.getMoney()).isEqualTo("0");
    }
}
