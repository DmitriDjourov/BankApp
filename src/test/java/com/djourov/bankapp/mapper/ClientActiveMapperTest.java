package com.djourov.bankapp.mapper;

import com.djourov.bankapp.dto.ClientActiveDto;
import com.djourov.bankapp.entity.Client;
import com.djourov.bankapp.util.EntityCreator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

class ClientActiveMapperTest {
    private final ClientActiveMapper clientActiveMapper = Mappers.getMapper(ClientActiveMapper.class);

    @Test
    void toDtoClientActiveMapperTest() {
        Client client = EntityCreator.getClient();
        ClientActiveDto clientDto = clientActiveMapper.toDto(client);
        Assertions.assertEquals(client.getFirstName(), clientDto.getFirstName());
        Assertions.assertEquals(client.getLastName(), clientDto.getLastName());
        Assertions.assertEquals(client.getPhone(), clientDto.getPhone());
        Assertions.assertEquals(client.getStatus().toString(), clientDto.getStatus());
    }

    @Test
    void toDtoListClientActiveMapperTest() {
        List<Client> client = new ArrayList<>();
        client.add(EntityCreator.getClient());
        List<ClientActiveDto> clientActiveDtoList = clientActiveMapper.toDtoList(client);
        Assertions.assertEquals(1, clientActiveDtoList.size());
        Assertions.assertEquals(client.get(0).getLastName(), clientActiveDtoList.get(0).getLastName());
        Assertions.assertEquals(client.get(0).getFirstName(), clientActiveDtoList.get(0).getFirstName());
        Assertions.assertEquals(client.get(0).getPhone(), clientActiveDtoList.get(0).getPhone());
        Assertions.assertEquals(client.get(0).getStatus().toString(), clientActiveDtoList.get(0).getStatus());
    }
}
