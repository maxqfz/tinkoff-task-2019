package ru.tinkoff.task.customerservice.logic;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.logging.LogLevel;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.tinkoff.eclair.annotation.Log;
import ru.tinkoff.task.customerservice.builder.DbCustomerBuilder;
import ru.tinkoff.task.customerservice.builder.RestCustomerBuilder;
import ru.tinkoff.task.customerservice.dto.RestCustomer;
import ru.tinkoff.task.customerservice.helper.ExceptionWrapper;
import ru.tinkoff.task.customerservice.configuration.CustomerRepository;

@Component
@RequiredArgsConstructor
public class AddCustomerOperation {
    private final CustomerRepository customerRepository;
    private final DbCustomerBuilder dbCustomerBuilder;
    private final RestCustomerBuilder restCustomerBuilder;

    @Log(LogLevel.INFO)
    @Transactional
    public RestCustomer process(RestCustomer restCustomer) {
        return ExceptionWrapper.wrap(() -> innerProcess(restCustomer));
    }

    private RestCustomer innerProcess(RestCustomer request) {
        return restCustomerBuilder.build(
                customerRepository.save(
                        dbCustomerBuilder.build(request)
                )
        );
    }
}