package com.djourov.bankapp.service.impl;

import com.djourov.bankapp.dto.ClientActiveDto;
import com.djourov.bankapp.dto.ClientDto;
import com.djourov.bankapp.entity.Client;
import com.djourov.bankapp.entity.enums.ClientStatus;
import com.djourov.bankapp.exception.ClientByIdNotFountException;
import com.djourov.bankapp.mapper.ClientActiveMapper;
import com.djourov.bankapp.mapper.ClientMapper;
import com.djourov.bankapp.repository.ClientRepository;
import com.djourov.bankapp.util.DtoCreator;
import com.djourov.bankapp.util.EntityCreator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.clearInvocations;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClientServiceImplTest {
    @Mock
    private ClientRepository clientRepository;
    @Mock
    private ClientMapper clientMapper;
    @Mock
    private ClientActiveMapper clientActiveMapper;

    @InjectMocks
    private ClientServiceImpl clientService;

    @AfterEach
    public void clearMocks() {
        clearInvocations(clientRepository, clientMapper, clientActiveMapper);
    }

    @Test
    void getAllClientsTest() {
        List<Client> clientList = new ArrayList<>();
        clientList.add(EntityCreator.getClient());
        when(clientRepository.findAll()).thenReturn(clientList);
        List<Client> result = clientService.getAllClients();
        Assertions.assertNotNull(result);
        Assertions.assertEquals(clientList, result);
    }

    @Test
    void getClientByIdTest() {
        Client client = EntityCreator.getClient();
        ClientDto clientDto = DtoCreator.getClientDto();
        when(clientRepository.findById(client.getId())).thenReturn(Optional.of(client));
        when(clientMapper.toDto(client)).thenReturn(clientDto);
        ClientDto actualClientDto = clientService.getClientById(client.getId());
        Assertions.assertEquals(actualClientDto, clientDto);
    }

    @Test
    void getClientByIdThrowExceptionTest() {
        UUID id = EntityCreator.getClient().getId();
        when(clientRepository.findById(id)).thenReturn(Optional.empty());
        Assertions.assertThrows(ClientByIdNotFountException.class, () -> clientService.getClientById(id));
    }

    @Test
    void getClientActiveDtoTest() {
        Integer status = 0;
        List<Client> clients = new ArrayList<>();
        clients.add(EntityCreator.getClient());
        List<ClientActiveDto> clientActiveDtoList = new ArrayList<>();
        clientActiveDtoList.add(DtoCreator.getClientActiveDto());
        when(clientRepository.findClientByStatus(ClientStatus.ACTIVE)).thenReturn(clients);
        when(clientActiveMapper.toDtoList(clients)).thenReturn(clientActiveDtoList);
        List<ClientActiveDto> actualClientDto = clientService.getClientActiveDto(status);
        Assertions.assertNotNull(actualClientDto);
        Assertions.assertEquals(actualClientDto, clientActiveDtoList);
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

    @ParameterizedTest
    @CsvSource({
            "0, ACTIVE",
            "1, FROZEN",
            "2, OVERDUE",
            "3, PRIVILEGED",
            "4, CLOSED",
            "5, "
    })
    void testFindStatus(Integer input, String status) {
        ClientStatus expected_null = (status == null || status.isEmpty()) ? null : ClientStatus.valueOf(status);
        Assertions.assertEquals(expected_null, findStatus(input));
    }
}