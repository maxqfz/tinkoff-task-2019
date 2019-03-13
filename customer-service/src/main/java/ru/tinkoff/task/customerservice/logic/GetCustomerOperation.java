package ru.tinkoff.task.customerservice.logic;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.logging.LogLevel;
import org.springframework.stereotype.Component;
import ru.tinkoff.eclair.annotation.Log;
import ru.tinkoff.task.customerservice.builder.RestCustomerBuilder;
import ru.tinkoff.task.customerservice.configuration.CustomerRepository;
import ru.tinkoff.task.customerservice.dto.RestCustomer;
import ru.tinkoff.task.customerservice.error.CustomerNotFoundException;
import ru.tinkoff.task.customerservice.helper.ExceptionWrapper;

@Component
@RequiredArgsConstructor
public class GetCustomerOperation {
    private final CustomerRepository customerRepository;
    private final RestCustomerBuilder restCustomerBuilder;

    @Log(LogLevel.INFO)
    public RestCustomer process(long id) {
        return ExceptionWrapper.wrap(() -> innerProcess(id));
    }

    private RestCustomer innerProcess(long id) {
        return restCustomerBuilder.build(
                customerRepository.findById(id).orElseThrow(
                        () -> new CustomerNotFoundException(id)
                )
        );
    }
}