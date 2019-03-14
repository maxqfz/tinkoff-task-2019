package ru.tinkoff.task.commonservice.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_GATEWAY)
public class RestServiceException extends RuntimeException {
    public RestServiceException() {
        super("Can't get data from REST service! ");
    }
    public RestServiceException(Exception e) { super(e); }
}