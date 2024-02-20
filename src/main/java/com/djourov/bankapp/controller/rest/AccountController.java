package com.djourov.bankapp.controller.rest;

import com.djourov.bankapp.dto.AccountDto;
import com.djourov.bankapp.entity.Account;
import com.djourov.bankapp.service.interf.AccountService;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/app/account")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @GetMapping("/accounts")//localhost:8080/app/account/accounts
    @Operation(summary = "The method returns information about accounts from the accounts table",
            description = "The method returns the values of all fields of all records from the accounts table",
            tags = "Accounts",
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
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/account_client_manager/{id}")// localhost:8080/app/account/account_client_manager/30633730-6166-6131-2d63-3635342d3437
    @Operation(summary = "This method returns information about the account by its identifier.",
            description = "TThis method returns a account record from the accounts table by the unique account" +
                                  " identifier. The information includes fields from the accounts table, the first" +
                                  " and last name of the account owner and the status(specialization) of the manager" +
                                  " servicing this account.",
            tags = "Accounts",
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
    public AccountDto getAccountAndClientAndManger(@PathVariable("id") UUID id) {
        return accountService.getACMId(id);
    }

    @GetMapping("/{id}")//localhost:8080/app/account/30633730-6166-6131-2d63-3635342d3437(не работает)
    @Operation(summary = "The method returns information about account by its identifier",
            description = "This method returns a complete account record from the accounts table by the account's unique identifier.",
            tags = "Accounts",
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
    public Account getAccountByID(@PathVariable("id") UUID id) {
        Account account = accountService.getAccById(id);
        return (Account) Hibernate.unproxy(account);
    }

    @GetMapping("/account_number/{a_account_number}")//localhost:8080/app/account/account_number/123456789
    @Operation(summary = "The method returns information about account by its account number",
            description = "This method returns a complete account record from the accounts table by the account's " +
                                  "unique account number.",
            tags = "Accounts",
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
    public ResponseEntity<Account> findAccountByAccountNumber(@PathVariable("a_account_number") String a_account_number) {
        Account account = accountService.findAccountByAccountNumber(a_account_number);
        if (account != null) {
            return ResponseEntity.ok(account);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}