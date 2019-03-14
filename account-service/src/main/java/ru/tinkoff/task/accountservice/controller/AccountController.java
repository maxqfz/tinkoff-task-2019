package ru.tinkoff.task.accountservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.logging.LogLevel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.tinkoff.eclair.annotation.Log;
import ru.tinkoff.task.accountservice.dto.RestAccount;
import ru.tinkoff.task.accountservice.dto.RestTransaction;
import ru.tinkoff.task.accountservice.logic.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AccountController {
    private final AddAccountOperation addAccountOperation;
    private final DeleteAccountOperation deleteAccountOperation;
    private final GetAccountOperation getAccountOperation;
    private final GetAccountsByCustomerOperation getAccountsByCustomerOperation;
    private final TransactionByIdOperation transactionByIdOperation;
    private final TransactionByNumberOperation transactionByNumberOperation;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    @Log(LogLevel.DEBUG)
    public RestAccount addAccount(@RequestBody RestAccount restAccount) {
        return addAccountOperation.process(restAccount);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Log(LogLevel.DEBUG)
    public void deleteAccount(@PathVariable long id) {
        deleteAccountOperation.process(id);
    }

    @GetMapping("/{id}")
    @Log(LogLevel.DEBUG)
    public RestAccount getAccount(@PathVariable long id) {
        return getAccountOperation.process(id);
    }

    @GetMapping("/customer/{customerId}")
    @Log(LogLevel.DEBUG)
    public List<RestAccount> getAccountsByCustomer(@PathVariable long customerId) {
        return getAccountsByCustomerOperation.process(customerId);
    }

    @PutMapping("/transaction/by-id/{id}")
    @Log(LogLevel.DEBUG)
    public RestAccount makeTransactionWithAccount(@PathVariable long id,
                                                  @RequestBody RestTransaction restTransaction) {
        return transactionByIdOperation.process(id, restTransaction);
    }

    @PutMapping("/transaction/by-number/{number}")
    @Log(LogLevel.DEBUG)
    public RestAccount withdrawAccountWithNumber(@PathVariable String number,
                                                 @RequestBody RestTransaction restTransaction) {
        return transactionByNumberOperation.process(number, restTransaction);
    }
}