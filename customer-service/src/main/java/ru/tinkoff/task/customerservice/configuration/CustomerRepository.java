package ru.tinkoff.task.customerservice.configuration;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tinkoff.task.customerservice.dto.DbCustomer;

public interface CustomerRepository extends JpaRepository<DbCustomer, Long> {
}