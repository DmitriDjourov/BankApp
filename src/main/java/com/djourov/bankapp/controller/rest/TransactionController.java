package com.djourov.bankapp.controller.rest;

import com.djourov.bankapp.entity.Transaction;
import com.djourov.bankapp.service.interf.TransactionService;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/app/transaction")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;

    @GetMapping("/transactions")//localhost:8080/app/transaction/transactions
    @Operation(summary = "The method returns information about transactions from the agreements table",
            description = "The method returns the values of all fields of all records from the transactions table",
            tags = "Transactions",
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
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }
}
