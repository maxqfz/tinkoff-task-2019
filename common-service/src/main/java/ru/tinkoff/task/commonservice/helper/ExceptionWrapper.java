package ru.tinkoff.task.commonservice.helper;

import ru.tinkoff.task.commonservice.errors.RestServiceException;
import ru.tinkoff.task.commonservice.errors.SomeOtherUnforeseenException;

import java.util.concurrent.Callable;

public class ExceptionWrapper {
    public static <T> T wrap(Callable<T> callable) {
        try {
            return callable.call();
        } catch (RestServiceException e) {
            throw e;
        } catch (Exception e) {
            throw new SomeOtherUnforeseenException(e);
        }
    }
}