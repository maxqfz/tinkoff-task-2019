package ru.tinkoff.task.commonservice.logic;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.tinkoff.task.commonservice.builder.RestTransactionBuilder;
import ru.tinkoff.task.commonservice.dto.RestTransferByNumber;
import ru.tinkoff.task.commonservice.errors.NoAccountSpecifiedException;
import ru.tinkoff.task.commonservice.errors.NoAmountSpecifiedException;
import ru.tinkoff.task.commonservice.helper.ExceptionWrapper;
import ru.tinkoff.task.commonservice.service.rest.AccountServiceClientAdapter;

@Component
@RequiredArgsConstructor
public class TransferByNumberOperation {
    private final AccountServiceClientAdapter accountServiceClientAdapter;
    private final RestTransactionBuilder restTransactionBuilder;

    public void process(RestTransferByNumber restTransferByNumber) {
        ExceptionWrapper.wrap(() -> {
            innerProcess(restTransferByNumber);
            return null;
        });
    }

    private void innerProcess(RestTransferByNumber restTransferByNumber) {
        if(restTransferByNumber.getFromAccount() == null || restTransferByNumber.getToAccount() == null)
            throw new NoAccountSpecifiedException();
        if(restTransferByNumber.getAmount() == null)
            throw new NoAmountSpecifiedException();

        accountServiceClientAdapter.makeTransactionByNumber(
                restTransferByNumber.getFromAccount(),
                restTransactionBuilder.buildFromTransaction(restTransferByNumber)
        );
        accountServiceClientAdapter.makeTransactionByNumber(
                restTransferByNumber.getToAccount(),
                restTransactionBuilder.buildToTransaction(restTransferByNumber)
        );
        //TODO: If second operation fails (ex. no such account), roll back first
    }
}
