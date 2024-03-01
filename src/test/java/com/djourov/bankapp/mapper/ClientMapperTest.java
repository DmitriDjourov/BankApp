package com.djourov.bankapp.mapper;

import com.djourov.bankapp.dto.ClientDto;
import com.djourov.bankapp.entity.Client;
import com.djourov.bankapp.entity.Manager;
import com.djourov.bankapp.entity.enums.ManagerStatus;
import com.djourov.bankapp.util.EntityCreator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

class ClientMapperTest {
    private final ClientMapper clientMapper = Mappers.getMapper(ClientMapper.class);
    @Test
    void toDtoClientMapperTest() {
        Client client = EntityCreator.getClient();
        Manager manager = EntityCreator.getManager();
        manager.setFirstName("Coco");
        manager.setLastName("Schnell");
        manager.setStatus(ManagerStatus.SENIOR_MANAGER);
        client.setManager(manager);
        ClientDto clientDto = clientMapper.toDto(client);
        Assertions.assertEquals(client.getFirstName(), clientDto.getFirstName());
        Assertions.assertEquals(client.getLastName(), clientDto.getLastName());
        Assertions.assertEquals(manager.getFirstName(), clientDto.getFirstNameManager());
        Assertions.assertEquals(manager.getLastName(), clientDto.getLastNameManager());
        Assertions.assertEquals(manager.getStatus(), clientDto.getStatus());
    }
}