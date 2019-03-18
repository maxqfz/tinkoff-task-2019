package ru.tinkoff.task.accountservice;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.tinkoff.task.accountservice.configuration.AccountRepository;
import ru.tinkoff.task.accountservice.controller.AccountController;

@SpringBootTest
public abstract class AbstractTest {
    @Autowired
    protected AccountController accountController;
    @MockBean
    protected AccountRepository accountRepository;
}
