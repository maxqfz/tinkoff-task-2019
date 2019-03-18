package ru.tinkoff.task.commonservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.tinkoff.task.commonservice.controller.CommonController;
import ru.tinkoff.task.commonservice.service.rest.AccountServiceClient;
import ru.tinkoff.task.commonservice.service.rest.CustomerServiceClient;

@SpringBootTest
public abstract class AbstractTest {
    @Autowired
    CommonController commonController;
    @MockBean
    AccountServiceClient accountServiceClient;
    @MockBean
    CustomerServiceClient customerServiceClient;
}
