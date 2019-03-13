package ru.tinkoff.task.customerservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.logging.LogLevel;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import ru.tinkoff.eclair.annotation.Log;
import ru.tinkoff.task.customerservice.dto.RestCustomer;
import ru.tinkoff.task.customerservice.logic.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CustomerController {
    private final AddCustomerOperation addCustomerOperation;
    private final DeleteCustomerOperation deleteCustomerOperation;
    private final ChangeCustomerOperation changeCustomerOperation;
    private final GetAllCustomersOperation getAllCustomersOperation;
    private final GetCustomerOperation getCustomerOperation;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    @Log(LogLevel.DEBUG)
    public RestCustomer addCustomer(@RequestBody RestCustomer restCustomer) {
        return addCustomerOperation.process(restCustomer);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Log(LogLevel.DEBUG)
    public void deleteCustomer(@PathVariable long id) {
        deleteCustomerOperation.process(id);
    }

    @PutMapping("/{id}")
    @Log(LogLevel.DEBUG)
    public RestCustomer changeCustomer(@PathVariable @NotNull long id,
                                       @RequestBody RestCustomer restCustomer) {
        return changeCustomerOperation.process(id, restCustomer);
    }

    @GetMapping("/{id}")
    @Log(LogLevel.DEBUG)
    public RestCustomer getCustomer(@PathVariable long id) {
        return getCustomerOperation.process(id);
    }

    @GetMapping
    @Log(LogLevel.DEBUG)
    public List<RestCustomer> getAllCustomers() {
        return getAllCustomersOperation.process();
    }
}