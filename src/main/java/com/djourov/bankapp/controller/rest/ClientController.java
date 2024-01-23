package com.djourov.bankapp.controller.rest;

import com.djourov.bankapp.dto.ClientDto;
import com.djourov.bankapp.entity.Client;
import com.djourov.bankapp.service.interf.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/app/client")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @GetMapping("/clients")//http:/localhost:8080/app/client/clients
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/{id}")//localhost:8080/app/client/b40a6773-b49f-11ee-9c53-00ffe0e1a544
    public ClientDto getClientById(@PathVariable("id") UUID id) {
        return clientService.getClientById(id);

    }
}
