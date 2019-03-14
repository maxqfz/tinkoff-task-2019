package ru.tinkoff.task.commonservice.service.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.logging.LogLevel;
import org.springframework.stereotype.Component;
import ru.tinkoff.eclair.annotation.Log;
import ru.tinkoff.task.commonservice.dto.service.RestCustomer;

@Component
@RequiredArgsConstructor
public class CustomerServiceClientAdapter {
    private final CustomerServiceClient customerServiceClient;

    @Log(LogLevel.DEBUG)
    public RestCustomer getCustomer(long id) {
        return customerServiceClient.getCustomer(id);
    }
}