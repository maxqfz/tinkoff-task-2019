package ru.tinkoff.task.accountservice.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Sad, really sad")
public class SomeOtherUnforeseenException extends RuntimeException {
    public SomeOtherUnforeseenException(Exception e) {
        super(e);
    }
}