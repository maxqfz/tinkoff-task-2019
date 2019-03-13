package ru.tinkoff.task.accountservice.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException() {
        super("No entity with such id exists! ");
    }

    public AccountNotFoundException(Long id) {
        super("No entity with id " + id + " exists! ");
    }

    public AccountNotFoundException(String number) {
        super("No entity with number " + number + " exists! ");
    }
}