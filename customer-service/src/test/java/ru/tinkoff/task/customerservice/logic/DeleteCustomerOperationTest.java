package ru.tinkoff.task.customerservice.logic;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.tinkoff.task.customerservice.AbstractTest;
import ru.tinkoff.task.customerservice.dto.DbCustomer;
import ru.tinkoff.task.customerservice.dto.RestCustomer;

import static org.mockito.ArgumentMatchers.any;

public class DeleteCustomerOperationTest extends AbstractTest {
    @Test
    public void testRepoIsUsed() {
        //given
        long id = 1;

        //when
        customerController.deleteCustomer(id);

        //then
        Mockito.verify(customerRepository).deleteById(id);
    }
}
