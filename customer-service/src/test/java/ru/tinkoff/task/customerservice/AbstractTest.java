package ru.tinkoff.task.customerservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.tinkoff.task.customerservice.configuration.CustomerRepository;
import ru.tinkoff.task.customerservice.controller.CustomerController;

@SpringBootTest
public abstract class AbstractTest {
    @Autowired
    protected CustomerController customerController;
    @MockBean
    protected CustomerRepository customerRepository;
}