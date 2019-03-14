package ru.tinkoff.task.accountservice.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class NoCustomerSpecifiedException extends RuntimeException {
    public NoCustomerSpecifiedException() {
        super("No customerId specified in request!");
    }
}