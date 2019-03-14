package ru.tinkoff.task.commonservice.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class NoAmountSpecifiedException extends RuntimeException {
    public NoAmountSpecifiedException() {
        super("No amount specified in request!");
    }
}