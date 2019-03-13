package ru.tinkoff.task.accountservice.configuration;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.tinkoff.task.accountservice.dto.DbAccount;

public interface AccountRepository extends JpaRepository<DbAccount, Long> {
    Page<DbAccount> findByNumber(String number, Pageable pageRequest);
}