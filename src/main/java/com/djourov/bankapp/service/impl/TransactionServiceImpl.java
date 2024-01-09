package com.djourov.bankapp.service.impl;

import com.djourov.bankapp.entity.Transaction;
import com.djourov.bankapp.repository.TransactionRepository;
import com.djourov.bankapp.service.interf.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    @Override
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }
}
