package ru.tinkoff.task.accountservice.dto;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "Accounts")
public class DbAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true, nullable = false)
    private String number;

    @Column(nullable = false)
    private long clientId;

    @Column(precision = 11, scale = 2, nullable = false)
    private BigDecimal money;
}