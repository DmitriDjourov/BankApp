package com.djourov.bankapp.service.interf;

import com.djourov.bankapp.dto.ClientDto;
import com.djourov.bankapp.entity.Client;
import com.djourov.bankapp.entity.Manager;

import java.util.List;
import java.util.UUID;

public interface ClientService {
    List<Client> getAllClients();

    ClientDto getClientById(UUID id);
}
