package ru.tinkoff.task.customerservice.logic;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.logging.LogLevel;
import org.springframework.stereotype.Component;
import ru.tinkoff.eclair.annotation.Log;
import ru.tinkoff.task.customerservice.builder.RestCustomerListBuilder;
import ru.tinkoff.task.customerservice.configuration.CustomerRepository;
import ru.tinkoff.task.customerservice.dto.RestCustomer;
import ru.tinkoff.task.customerservice.helper.ExceptionWrapper;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetAllCustomersOperation {
    private final CustomerRepository customerRepository;
    private final RestCustomerListBuilder restCustomerListBuilder;

    @Log(LogLevel.INFO)
    public List<RestCustomer> process() {
        return ExceptionWrapper.wrap(this::innerProcess);
    }

    private List<RestCustomer> innerProcess() {
        return restCustomerListBuilder.build(
                customerRepository.findAll()
        );
    }
}