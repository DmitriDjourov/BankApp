package com.djourov.bankapp.service.impl;

import com.djourov.bankapp.entity.Client;
import com.djourov.bankapp.repository.ClientRepository;
import com.djourov.bankapp.service.interf.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }
}
