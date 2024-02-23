package com.djourov.bankapp.service.impl;

import com.djourov.bankapp.entity.Transaction;
import com.djourov.bankapp.repository.TransactionRepository;
import com.djourov.bankapp.util.EntityCreator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TransactionServiceImplTest {
    @Mock
    private TransactionRepository transactionRepository;
    @InjectMocks
    private TransactionServiceImpl transactionService;

    @Test
    void getAllTransactions() {
        List<Transaction> transactionList = new ArrayList<>();
        transactionList.add(EntityCreator.transaction());
        when(transactionRepository.findAll()).thenReturn(transactionList);
        List<Transaction> result = transactionService.getAllTransactions();
        Assertions.assertNotNull(result);
        Assertions.assertEquals(transactionList,result);
    }
}