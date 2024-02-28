package com.djourov.bankapp.controller.rest;

import com.djourov.bankapp.dto.ClientDto;
import com.djourov.bankapp.entity.Client;
import com.djourov.bankapp.service.impl.ClientServiceImpl;
import com.djourov.bankapp.util.DtoCreator;
import com.djourov.bankapp.util.EntityCreator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@WebMvcTest(ClientController.class)
@DisplayName("ClientController test class")
class ClientControllerTest {

    @Autowired
    ClientController clientController;

    @MockBean
    private ClientServiceImpl clientService;

    @Autowired
    private MockMvc mockMvc;
    private final Client client = EntityCreator.getClient();

    @Test
    void getAllClientsTest() throws Exception {
        List<Client> clients = new ArrayList<>();
        clients.add(client);
        when(clientService.getAllClients()).thenReturn(clients);
        mockMvc.perform(get("/app/client/clients"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id").value(client.getId().toString()))
                .andExpect(jsonPath("$[0].status").value(client.getStatus().toString()))
                .andExpect(jsonPath("$[0].taxCode").value(client.getTaxCode()))
                .andExpect(jsonPath("$[0].firstName").value(client.getFirstName()))
                .andExpect(jsonPath("$[0].lastName").value(client.getLastName()))
                .andExpect(jsonPath("$[0].email").value(client.getEmail()))
                .andExpect(jsonPath("$[0].address").value(client.getAddress()))
                .andExpect(jsonPath("$[0].phone").value(client.getPhone()))
                .andExpect(jsonPath("$[0].createdAt").value(client.getCreatedAt().toString()))
                .andExpect(jsonPath("$[0].updatedAt").value(client.getUpdatedAt().toString()));
    }

    @Test
    void getClientByIdTest() throws Exception {
        ClientDto clientDto = DtoCreator.getClientDto();
        when(clientService.getClientById(client.getId())).thenReturn(clientDto);
        mockMvc.perform(get("/app/client/{id}", client.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName", is(clientDto.getFirstName())))
                .andExpect(jsonPath("$.lastName", is(clientDto.getLastName())))
                .andExpect(jsonPath("$.firstNameManager", is(clientDto.getFirstNameManager())))
                .andExpect(jsonPath("$.lastNameManager", is(clientDto.getLastNameManager())))
                .andExpect(jsonPath("$.status", is(clientDto.getStatus().toString())));
    }

    @Test
    void getClientActiveTest() throws Exception {
        int status = 0;
        mockMvc.perform(get("/app/client/active/{status}", status))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }

}