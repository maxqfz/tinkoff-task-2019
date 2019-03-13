package ru.tinkoff.task.customerservice.logic;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.logging.LogLevel;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.tinkoff.eclair.annotation.Log;
import ru.tinkoff.task.customerservice.configuration.CustomerRepository;
import ru.tinkoff.task.customerservice.helper.ExceptionWrapper;

@Component
@RequiredArgsConstructor
public class DeleteCustomerOperation {
    private final CustomerRepository customerRepository;

    @Log(LogLevel.INFO)
    @Transactional
    public void process(long id) {
        ExceptionWrapper.wrap(() -> {
            innerProcess(id);
            return null;
        });
    }

    private void innerProcess(long id) {
        customerRepository.deleteById(id);
    }
}