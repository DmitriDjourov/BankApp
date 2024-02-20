package com.djourov.bankapp.controller.rest;

import com.djourov.bankapp.dto.ClientActiveDto;
import com.djourov.bankapp.dto.ClientDto;
import com.djourov.bankapp.entity.Client;
import com.djourov.bankapp.service.interf.ClientService;
import com.djourov.bankapp.validation.annotation.UuidChecker;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@Validated
@RestController
@RequestMapping("/app/client")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @GetMapping("/clients")//http:/localhost:8080/app/client/clients
    @Operation(summary = "The method returns information about clients from the clients table",
            description = "The method returns the values of all fields of all records from the clients table",
            tags = "Clients",
            externalDocs = @ExternalDocumentation(
                    description = "Documentation",
                    url = "https://google.com/"
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Found"),
                    @ApiResponse(responseCode = "500", description = "Not Found")
            },
            security = {
                    @SecurityRequirement(name = "security requirements")
            },
            hidden = false
    )
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/{id}")//localhost:8080/app/client/b40a6773-b49f-11ee-9c53-00ffe0e1a544
    @Operation(summary = "The method returns information about client by its identifier",
            description = "This method returns a complete client record from the clients table by the client's unique identifier.",
            tags = "Clients",
            externalDocs = @ExternalDocumentation(
                    description = "Documentation",
                    url = "https://google.com/"
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Found"),
                    @ApiResponse(responseCode = "500", description = "Not Found")
            },
            security = {
                    @SecurityRequirement(name = "security requirements")
            },
            hidden = false
    )
    public ClientDto getClientById(@UuidChecker @PathVariable("id") UUID id) {
        return clientService.getClientById(id);
    }

    @GetMapping("/active/{status}")// localhost:8080/app/client/active/0
    @Operation(summary = "The method returns information about client by its client active status",
            description = "This method returns a complete client record from the client table by the client's " +
                                  "client status.",
            tags = "Clients",
            externalDocs = @ExternalDocumentation(
                    description = "Documentation",
                    url = "https://google.com/"
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Found"),
                    @ApiResponse(responseCode = "404", description = "Not Found")
            },
            security = {
                    @SecurityRequirement(name = "security requirements")
            },
            hidden = false
    )
    public List<ClientActiveDto> getClientActive(@PathVariable("status") Integer status) {
        return clientService.getClientActiveDto(status);
    }
}
