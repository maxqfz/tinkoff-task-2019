package ru.tinkoff.task.accountservice.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class NoClientSpecifiedException extends RuntimeException {
    public NoClientSpecifiedException() {
        super("No client specified in request!");
    }
}