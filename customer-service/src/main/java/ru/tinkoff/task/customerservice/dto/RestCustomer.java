package ru.tinkoff.task.customerservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestCustomer {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String birthDate;
}