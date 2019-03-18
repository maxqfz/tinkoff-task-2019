package ru.tinkoff.task.commonservice.builder;

import org.springframework.stereotype.Component;
import ru.tinkoff.task.commonservice.dto.RestTransferById;
import ru.tinkoff.task.commonservice.dto.RestTransferByNumber;
import ru.tinkoff.task.commonservice.dto.service.RestAction;
import ru.tinkoff.task.commonservice.dto.service.RestTransaction;

@Component
public class RestTransactionBuilder {
    public RestTransaction buildFromTransaction(RestTransferById transfer) {
        RestTransaction transaction = new RestTransaction();
        transaction.setAction(RestAction.WITHDRAW);
        transaction.setAmount(transfer.getAmount());
        return transaction;
    }

    public RestTransaction buildToTransaction(RestTransferById transfer) {
        RestTransaction transaction = new RestTransaction();
        transaction.setAction(RestAction.DEPOSIT);
        transaction.setAmount(transfer.getAmount());
        return transaction;
    }

    public RestTransaction buildFromTransaction(RestTransferByNumber transfer) {
        RestTransaction transaction = new RestTransaction();
        transaction.setAction(RestAction.WITHDRAW);
        transaction.setAmount(transfer.getAmount());
        return transaction;
    }

    public RestTransaction buildToTransaction(RestTransferByNumber transfer) {
        RestTransaction transaction = new RestTransaction();
        transaction.setAction(RestAction.DEPOSIT);
        transaction.setAmount(transfer.getAmount());
        return transaction;
    }
}