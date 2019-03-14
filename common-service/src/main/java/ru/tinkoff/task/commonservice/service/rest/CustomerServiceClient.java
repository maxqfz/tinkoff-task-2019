package ru.tinkoff.task.commonservice.service.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import ru.tinkoff.task.commonservice.dto.service.RestCustomer;
import ru.tinkoff.task.commonservice.errors.RestServiceException;

@Component
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceClient {
    private final RestTemplate customerRestTemplate;

    public RestCustomer getCustomer(long id) {
        try {
            return customerRestTemplate.getForObject("/" + id, RestCustomer.class);
        } catch (RestClientException e) {
            throw new RestServiceException(e);
        }
    }
}