package ru.tinkoff.task.commonservice.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Shit happens")
public class SomeOtherUnforeseenException extends RuntimeException {
    public SomeOtherUnforeseenException(Exception e) {
        super(e);
    }
}