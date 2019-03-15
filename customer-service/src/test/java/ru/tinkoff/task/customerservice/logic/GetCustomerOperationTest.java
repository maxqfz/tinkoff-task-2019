package ru.tinkoff.task.customerservice.logic;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.tinkoff.task.customerservice.AbstractTest;
import ru.tinkoff.task.customerservice.dto.DbCustomer;
import ru.tinkoff.task.customerservice.error.CustomerNotFoundException;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

public class GetCustomerOperationTest extends AbstractTest {
    @Test
    public void testRepoIsUsed() throws CustomerNotFoundException {
        //given
        long id = 0;
        Mockito.when(customerRepository.findById(any())).thenReturn(Optional.of(new DbCustomer()));

        //when
        customerController.getCustomer(id);

        //then
        Mockito.verify(customerRepository).findById(id);
    }
}
