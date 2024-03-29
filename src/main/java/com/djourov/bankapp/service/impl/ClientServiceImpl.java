package com.djourov.bankapp.service.impl;

import com.djourov.bankapp.dto.ClientActiveDto;
import com.djourov.bankapp.dto.ClientDto;
import com.djourov.bankapp.entity.Client;
import com.djourov.bankapp.entity.enums.ClientStatus;
import com.djourov.bankapp.exception.ClientByIdNotFountException;
import com.djourov.bankapp.exception.message.ErrorMessages;
import com.djourov.bankapp.mapper.ClientActiveMapper;
import com.djourov.bankapp.mapper.ClientMapper;
import com.djourov.bankapp.repository.ClientRepository;
import com.djourov.bankapp.service.interf.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    @Autowired
    private final ClientRepository clientRepository;
    @Autowired
    private final ClientMapper clientMapper;
    @Autowired
    private final ClientActiveMapper clientActiveMapper;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, readOnly = true)
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public ClientDto getClientById(UUID id) {
        return clientMapper.toDto(clientRepository.findById(id)
                                          .orElseThrow(() -> new ClientByIdNotFountException(ErrorMessages.NO_CLIENT_WITH_ID, id)));
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, readOnly = true)
    public List<ClientActiveDto> getClientActiveDto(Integer status) {
        return clientActiveMapper.toDtoList(clientRepository.findClientByStatus(findStatus(status)));
    }

    private ClientStatus findStatus(Integer status) {
        return switch (status) {
            case 0 -> ClientStatus.ACTIVE;
            case 1 -> ClientStatus.FROZEN;
            case 2 -> ClientStatus.OVERDUE;
            case 3 -> ClientStatus.PRIVILEGED;
            case 4 -> ClientStatus.CLOSED;
            default -> null;
        };
    }
}



