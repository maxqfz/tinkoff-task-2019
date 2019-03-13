package ru.tinkoff.task.accountservice.helper;

import org.springframework.dao.DataAccessException;
import ru.tinkoff.task.accountservice.error.AccountNotFoundException;
import ru.tinkoff.task.accountservice.error.NoClientSpecifiedException;
import ru.tinkoff.task.accountservice.error.NotEnoughMoneyException;
import ru.tinkoff.task.accountservice.error.SomeOtherUnforeseenException;

import java.util.concurrent.Callable;

public class ExceptionWrapper {
    public static <T> T wrap(Callable<T> callable) {
        try {
            return callable.call();
        } catch (AccountNotFoundException |
                NoClientSpecifiedException |
                NotEnoughMoneyException e) {
            throw e;
        } catch (DataAccessException e) {
            throw new AccountNotFoundException();
        } catch (Exception e) {
            throw new SomeOtherUnforeseenException(e);
        }
    }
}