package ru.tinkoff.task.customerservice.logic;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.tinkoff.task.customerservice.AbstractTest;
import ru.tinkoff.task.customerservice.dto.DbCustomer;
import ru.tinkoff.task.customerservice.dto.RestCustomer;

import static org.mockito.ArgumentMatchers.any;

public class AddCustomerOperationTest extends AbstractTest {
    @Test
    public void testRepoIsUsed() {
        //given
        Mockito.when(customerRepository.save(any())).thenReturn(new DbCustomer());

        //when
        customerController.addCustomer(new RestCustomer());

        //then
        Mockito.verify(customerRepository).save(any());
    }
}
