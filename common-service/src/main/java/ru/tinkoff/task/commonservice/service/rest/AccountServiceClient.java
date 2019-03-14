package ru.tinkoff.task.commonservice.service.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import ru.tinkoff.task.commonservice.dto.service.RestAccount;
import ru.tinkoff.task.commonservice.errors.RestServiceException;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class AccountServiceClient {
    private final RestTemplate accountRestTemplate;

    @SuppressWarnings("unchecked")
    public List<RestAccount> getCustomerAccounts(long customerId) {
        try {
            return accountRestTemplate.getForObject("/customer/" + customerId, List.class);
        } catch (NullPointerException e) {
            throw new RestServiceException();
        } catch (RestClientException e) {
            throw new RestServiceException(e);
        }
    }
}