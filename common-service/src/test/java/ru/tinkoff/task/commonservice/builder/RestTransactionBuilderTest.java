package ru.tinkoff.task.commonservice.builder;

import org.junit.Test;
import ru.tinkoff.task.commonservice.dto.RestTransferById;
import ru.tinkoff.task.commonservice.dto.RestTransferByNumber;
import ru.tinkoff.task.commonservice.dto.service.RestAction;
import ru.tinkoff.task.commonservice.dto.service.RestTransaction;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class RestTransactionBuilderTest {
    private RestTransactionBuilder restTransactionBuilder = new RestTransactionBuilder();

    @Test
    public void transferByIdBuildTest() {
        //given
        RestTransferById restTransferById = givenRestTransferById();
        //when
        RestTransaction fromTransaction = restTransactionBuilder.buildFromTransaction(restTransferById);
        RestTransaction toTransaction = restTransactionBuilder.buildToTransaction(restTransferById);
        //then
        thenRestTransactionFrom(fromTransaction);
        thenRestTransactionTo(toTransaction);
    }

    @Test
    public void transferByNumberBuildTest() {
        //given
        RestTransferByNumber restTransferByNumber = givenRestTransferByNumber();
        //when
        RestTransaction fromTransaction = restTransactionBuilder.buildFromTransaction(restTransferByNumber);
        RestTransaction toTransaction = restTransactionBuilder.buildToTransaction(restTransferByNumber);
        //then
        thenRestTransactionFrom(fromTransaction);
        thenRestTransactionTo(toTransaction);
    }

    private RestTransferById givenRestTransferById() {
        RestTransferById restTransferById = new RestTransferById();
        restTransferById.setAmount(new BigDecimal("123.45"));
        restTransferById.setFromAccount(1);
        restTransferById.setToAccount(2);
        return restTransferById;
    }

    private RestTransferByNumber givenRestTransferByNumber() {
        RestTransferByNumber restTransferByNumber = new RestTransferByNumber();
        restTransferByNumber.setAmount(new BigDecimal("123.45"));
        restTransferByNumber.setFromAccount("from");
        restTransferByNumber.setToAccount("to");
        return restTransferByNumber;
    }

    private void thenRestTransactionFrom(RestTransaction restTransaction) {
        assertThat(restTransaction.getAction()).isEqualByComparingTo(RestAction.WITHDRAW);
        assertThat(restTransaction.getAmount()).isEqualTo("123.45");
    }

    private void thenRestTransactionTo(RestTransaction restTransaction) {
        assertThat(restTransaction.getAction()).isEqualByComparingTo(RestAction.DEPOSIT);
        assertThat(restTransaction.getAmount()).isEqualTo("123.45");
    }
}
