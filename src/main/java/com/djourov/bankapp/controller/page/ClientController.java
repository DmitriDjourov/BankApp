package com.djourov.bankapp.controller.page;

import com.djourov.bankapp.entity.Client;
import com.djourov.bankapp.service.impl.ClientServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/app/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientServiceImpl clientServiceImpl;
    @GetMapping("/clients")//http:/localhost:8080/app/client/clients
    public List<Client> getAllClients() {
        return clientServiceImpl.getAllClients();
    }

}
