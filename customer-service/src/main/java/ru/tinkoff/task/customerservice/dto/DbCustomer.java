package ru.tinkoff.task.customerservice.dto;

import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Date;

@Data
@Entity
@Table(name = "Customers")
public class DbCustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    @Column(precision = 11)
    private BigInteger phone;
    private Date birthDate;
}