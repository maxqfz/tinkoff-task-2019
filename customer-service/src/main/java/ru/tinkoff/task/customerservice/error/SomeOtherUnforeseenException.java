package ru.tinkoff.task.customerservice.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "That's really sad")
public class SomeOtherUnforeseenException extends RuntimeException {
    public SomeOtherUnforeseenException(Exception e) {
        super(e);
    }
}