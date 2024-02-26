package com.djourov.bankapp.controller.rest;

import com.djourov.bankapp.entity.Transaction;
import com.djourov.bankapp.service.impl.TransactionServiceImpl;
import com.djourov.bankapp.util.EntityCreator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@WebMvcTest(TransactionController.class)
@DisplayName("TransactionController test class")
class TransactionControllerTest {
    @Autowired
    TransactionController transactionController;

    @MockBean
    private TransactionServiceImpl transactionService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAllTransactionsTest() throws Exception {
        Transaction transaction = EntityCreator.getTransaction();
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(transaction);
        when(transactionService.getAllTransactions()).thenReturn(transactions);
        mockMvc.perform(get("/app/transaction/transactions"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id").value(transaction.getId().toString()))
                .andExpect(jsonPath("$[0].type").value(transaction.getType().name()))
                .andExpect(jsonPath("$[0].amount").value(transaction.getAmount().floatValue()))
                .andExpect(jsonPath("$[0].description").value(transaction.getDescription()))
                .andExpect(jsonPath("$[0].createAt").value(transaction.getCreateAt().toString()));
    }
}
