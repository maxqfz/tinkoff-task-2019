package ru.tinkoff.task.commonservice.logic;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.tinkoff.task.commonservice.builder.RestTransactionBuilder;
import ru.tinkoff.task.commonservice.dto.RestTransferById;
import ru.tinkoff.task.commonservice.errors.NoAccountSpecifiedException;
import ru.tinkoff.task.commonservice.errors.NoAmountSpecifiedException;
import ru.tinkoff.task.commonservice.helper.ExceptionWrapper;
import ru.tinkoff.task.commonservice.service.rest.AccountServiceClientAdapter;

@Component
@RequiredArgsConstructor
public class TransferByIdOperation {
    private final AccountServiceClientAdapter accountServiceClientAdapter;
    private final RestTransactionBuilder restTransactionBuilder;

    public void process(RestTransferById restTransferById) {
        ExceptionWrapper.wrap(() -> {
            innerProcess(restTransferById);
            return null;
        });
    }

    private void innerProcess(RestTransferById restTransferById) {
        if(restTransferById.getFromAccount() == 0 || restTransferById.getToAccount() == 0)
            throw new NoAccountSpecifiedException();
        if(restTransferById.getAmount() == null)
            throw new NoAmountSpecifiedException();

        accountServiceClientAdapter.makeTransactionById(
                restTransferById.getFromAccount(),
                restTransactionBuilder.buildFromTransaction(restTransferById)
        );
        accountServiceClientAdapter.makeTransactionById(
                restTransferById.getToAccount(),
                restTransactionBuilder.buildToTransaction(restTransferById)
        );
        //TODO: If second operation fails (ex. no such account), roll back first
    }
}
