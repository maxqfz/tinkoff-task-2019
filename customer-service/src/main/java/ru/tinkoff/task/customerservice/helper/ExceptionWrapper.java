package ru.tinkoff.task.customerservice.helper;

import org.springframework.dao.DataAccessException;
import ru.tinkoff.task.customerservice.error.CustomerNotFoundException;
import ru.tinkoff.task.customerservice.error.SomeOtherUnforeseenException;

import java.util.concurrent.Callable;

public class ExceptionWrapper {
    public static <T> T wrap(Callable<T> callable) {
        try {
            return callable.call();
        } catch (CustomerNotFoundException e) {
            throw e;
        } catch (DataAccessException e) {
            throw new CustomerNotFoundException();
        } catch (Exception e) {
            throw new SomeOtherUnforeseenException(e);
        }
    }
}