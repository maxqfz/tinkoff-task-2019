package ru.tinkoff.task.customerservice;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.tinkoff.task.customerservice.configuration.CustomerRepository;
import ru.tinkoff.task.customerservice.controller.CustomerController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public abstract class AbstractTest {
    @Autowired
    protected CustomerController customerController;
    @MockBean
    protected CustomerRepository customerRepository;
}