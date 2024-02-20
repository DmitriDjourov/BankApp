package com.djourov.bankapp.controller.rest;

import com.djourov.bankapp.dto.ManagerDTO;
import com.djourov.bankapp.entity.Manager;
import com.djourov.bankapp.service.interf.ManagerService;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/app/manager")
@RequiredArgsConstructor
public class ManagerController {
    private final ManagerService managerService;

    @GetMapping("/managers") // localhost:8080/app/manager/managers?format=json(xml)
    @Operation(summary = "The method returns information about managers from the managers table",
            description = "The method returns the values of all fields of all records from the managers table",
            tags = "Managers",
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
    public List<Manager> getAllManagers() {
        return managerService.getAllManagers();
    }

    @GetMapping("/first_last_name/{id}")
// localhost:8080/app/manager/first_last_name/1b0f92f6-c45d-11ee-bf28-00155d558765
    @Operation(summary = "This method returns information about the manager by its identifier.",
            description = "This method returns a manager record from the managers table by the unique manager" +
                                  " identifier. The information includes fields from the managers table, the first" +
                                  " ,last name and status of the manager" +
                                  " Local create time and list of clients",
            tags = "Managers",
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
    public ManagerDTO getManagerByIdFirstLastName(@PathVariable("id") UUID id) {
        return managerService.getManagerByIdFirstLastName(id);
    }

    @GetMapping("/{id}")// localhost:8080/app/manager/b407a7f7-b49f-11ee-9c53-00ffe0e1a544?format=json(xml)
    @Operation(summary = "The method returns information about manager by its identifier",
            description = "This method returns a complete manager record from the managers table by the manager's unique identifier.",
            tags = "Managers",
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
    public Manager getManagerById(@PathVariable("id") UUID id) {
        Manager manager = managerService.getManagerById(id);
        return (Manager) Hibernate.unproxy(manager);
    }

    /**
     * localhost:8080/app/manager/createManager
     * post postman Body raw JSON
     * {
     * "firstName": "Patrik",
     * "lastName": "Krolikoff",
     * "status": "CREDIT_MANAGER"
     * }
     */
    @PostMapping("/createManager")// localhost:8080/app/manager/createManager
    @Operation(summary = "Method for creating a new manager",
            description = "This method creates a new manager and enters all the necessary data into the managers table.",
            tags = "Managers",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Product data to save",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = Manager.class)
                    )
            )
    )
    public Manager postCreateManager(@RequestBody Manager manager) {
        return managerService.postCreateManager(manager);
    }

    /**
     * работает в postman как DELETE
     * localhost:8080/app/manager/del/799beb00-bfc7-4b10-a5c5-17d9a5be0472-взять из базы
     */
    @DeleteMapping("/del/{id}")// localhost:8080/app/manager/del/
    @Operation(summary = "Method for deleting a manager",
            description = "This method removes a manager record from the managers table according to its unique identifier.",
            tags = "Managers",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Product data to save",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = Manager.class)
                    )
            )
    )
    public Manager deleteManagerById(@PathVariable UUID id) {
        return managerService.deleteById(id);
    }

    /**
     * работает в postman как PUT
     * localhost:8080/app/manager/upd/manager_status_senior/83188565-b3f4-11ee-9c53-00ffe0e1a544-взять из базы
     */
    @PutMapping("/upd/manager_status_senior/{id}")//localhost:8080/app/manager/upd/manager_status_senior/
    @Operation(summary = "Method for assigning Senior status to a manager.",
            description = "This method assigns Signer status to a manager based on its unique ID.",
            tags = "Managers",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Product data to save",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = UUID.class)
                    )
            )
    )
    public Manager updateManagerStatusSeniorById(@PathVariable UUID id) {
        return managerService.updateManagerStatusSeniorById(id);
    }
}
