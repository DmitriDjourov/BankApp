package com.djourov.bankapp.controller.rest;

import com.djourov.bankapp.entity.Transaction;
import com.djourov.bankapp.service.interf.TransactionService;
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

    @GetMapping("/transactions")//http:/localhost:8080/app/transaction/transactions
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }
}
