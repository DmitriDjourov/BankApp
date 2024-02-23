package com.djourov.bankapp.controller.rest;

import com.djourov.bankapp.entity.Account;
import com.djourov.bankapp.entity.enums.AccountCurrencyCode;
import com.djourov.bankapp.entity.enums.AccountStatus;
import com.djourov.bankapp.entity.enums.AccountTypeStatus;
import com.djourov.bankapp.repository.AccountRepository;
import com.djourov.bankapp.service.interf.AccountService;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.UUID;

import static org.mockito.Mockito.when;

@SpringBootTest
public class AccountControllerTest {
    @InjectMocks
    private AccountController accountController;
    @Mock
    private AccountService accountService;
    @Mock
    private AccountRepository accountRepository;
    @Mock
    private Service service;
    private final Account account = new Account();

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);

        account.setId(UUID.fromString("91384699-c928-11ee-87e5-00155d26ef58"));
        account.setAccountNumber("123456789");
        account.setType(AccountTypeStatus.BUSINESS_ACCOUNT);
        account.setStatus(AccountStatus.ACTIVE);
        account.setBalance(new BigDecimal("2222.00"));
        account.setCurrencyCode(AccountCurrencyCode.EUR);
        account.setCreatedAt(LocalDate.of(2024, Month.FEBRUARY, 11));
        account.setUpdatedAt(LocalDate.of(2024, Month.FEBRUARY, 12));

    }

    @Test
    void getAllAccounts() {
    }

    @Test
    void getAccountAndClientAndManger() {
    }

    @Test
    void getAccountByIDTest() {
        Account expectedAccount = new Account();
        when(accountService.getAccById(UUID.fromString(String.valueOf(account.getId())))).thenReturn(expectedAccount);
        Account result = accountController.getAccountByID(UUID.fromString(String.valueOf(account.getId())));

        Assert.assertEquals(expectedAccount, result);
        Assert.assertNotNull(result);
    }

    @Test
    void findAccountByAccountNumber() {
    }
}