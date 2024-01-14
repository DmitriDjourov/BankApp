package com.djourov.bankapp.service.interf;

import com.djourov.bankapp.entity.Transaction;

import java.util.List;

public interface TransactionService {
    List<Transaction> getAllTransactions();
}
