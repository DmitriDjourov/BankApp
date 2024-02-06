package com.djourov.bankapp.dto;

import com.djourov.bankapp.entity.Client;
import com.djourov.bankapp.entity.enums.ManagerStatus;
import lombok.Value;

import java.time.LocalDate;
import java.util.List;

@Value
public class ManagerDTO {
     String firstName;
     String lastName;
     ManagerStatus status;
     LocalDate createdAt;
     List<Client> clients;
}
