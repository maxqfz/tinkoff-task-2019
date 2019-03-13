package ru.tinkoff.task.customerservice.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException() {
        super("No entity with such id exists! ");
    }

    public CustomerNotFoundException(Long id) {
        super("No entity with id " + id + " exists! ");
    }
}