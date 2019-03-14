package ru.tinkoff.task.commonservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.logging.LogLevel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.tinkoff.eclair.annotation.Log;
import ru.tinkoff.task.commonservice.dto.RestCustomerWithAccounts;
import ru.tinkoff.task.commonservice.dto.RestTransferById;
import ru.tinkoff.task.commonservice.dto.RestTransferByNumber;
import ru.tinkoff.task.commonservice.logic.GetCustomerWithAccountsOperation;
import ru.tinkoff.task.commonservice.logic.TransferByIdOperation;
import ru.tinkoff.task.commonservice.logic.TransferByNumberOperation;

@RestController
@RequiredArgsConstructor
public class CommonController {
    private final GetCustomerWithAccountsOperation getCustomerWithAccountsOperation;
    private final TransferByIdOperation transferByIdOperation;
    private final TransferByNumberOperation transferByNumberOperation;

    @GetMapping("/{id}")
    @Log(LogLevel.DEBUG)
    public RestCustomerWithAccounts getCustomerWithAccounts(@PathVariable long id) {
        return getCustomerWithAccountsOperation.process(id);
    }

    @PostMapping("/transfer/by-id")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Log(LogLevel.DEBUG)
    public void transferById(@RequestBody RestTransferById restTransferById) {
        transferByIdOperation.process(restTransferById);
    }

    @PostMapping("/transfer/by-number")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Log(LogLevel.DEBUG)
    public void transferByNumber(@RequestBody RestTransferByNumber restTransferByNumber) {
        transferByNumberOperation.process(restTransferByNumber);
    }
}