package com.djourov.bankapp.mapper;

import com.djourov.bankapp.dto.ManagerDTO;
import com.djourov.bankapp.entity.Client;
import com.djourov.bankapp.entity.Manager;
import com.djourov.bankapp.util.EntityCreator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ManagerMapperTest {
    private final ManagerMapper managerMapper = new ManagerMapperImpl();
    @Test
    void toDtoManagerMapperTest() {
        Manager manager = EntityCreator.getManager();
        List<Client> clients = new ArrayList<>();
        clients.add(EntityCreator.getClient());
        ManagerDTO managerDTO = managerMapper.toDto(manager);
        Assertions.assertNotNull(managerDTO);
        Assertions.assertEquals(manager.getFirstName(),managerDTO.getFirstName());
        Assertions.assertEquals(manager.getLastName(),managerDTO.getLastName());
        Assertions.assertEquals(manager.getStatus().toString(),managerDTO.getStatus().toString());
    }
}