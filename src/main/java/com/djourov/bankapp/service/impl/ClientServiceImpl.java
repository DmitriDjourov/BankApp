package com.djourov.bankapp.service.impl;

import com.djourov.bankapp.dto.ClientDto;
import com.djourov.bankapp.entity.Client;
import com.djourov.bankapp.entity.Manager;
import com.djourov.bankapp.exception.ManagerNotFoundException;
import com.djourov.bankapp.exception.message.ErrorMessages;
import com.djourov.bankapp.mapper.ClientMapper;
import com.djourov.bankapp.repository.ClientRepository;
import com.djourov.bankapp.service.interf.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;
    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }
    @Override
    public ClientDto getClientById(UUID id) {
        return clientMapper.toDto(clientRepository.getReferenceById(id));
    }

}
