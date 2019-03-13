package ru.tinkoff.task.accountservice.helper;

import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.UUID;

@Component
public class AccountNumberGenerator {
    public String generate() {
        return String.format("%040d", new BigInteger(UUID.randomUUID()
                .toString().replace("-", ""), 16));
    }
}