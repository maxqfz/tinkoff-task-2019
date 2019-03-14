package ru.tinkoff.task.commonservice.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class NoAccountSpecifiedException extends RuntimeException {
    public NoAccountSpecifiedException() {
        super("No account specified in request!");
    }
}