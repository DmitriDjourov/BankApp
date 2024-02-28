package com.djourov.bankapp.controller.rest;

import com.djourov.bankapp.dto.AccountDto;
import com.djourov.bankapp.entity.Account;
import com.djourov.bankapp.entity.enums.AccountCurrencyCode;
import com.djourov.bankapp.entity.enums.AccountStatus;
import com.djourov.bankapp.entity.enums.AccountTypeStatus;
import com.djourov.bankapp.service.impl.AccountServiceImpl;
import com.djourov.bankapp.util.DtoCreator;
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

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@WebMvcTest(AccountController.class)
@DisplayName("AccountController test class")
class AccountControllerTest {
    @Autowired
    AccountController accountController;
    @MockBean
    private AccountServiceImpl accountService;
    @Autowired
    private MockMvc mockMvc;
    private final Account account = EntityCreator.getAccount();

    @Test
    void getAllAccountsTest() throws Exception {
        List<Account> accounts = new ArrayList<>();
        accounts.add(account);
        when(accountService.getAllAccounts()).thenReturn(accounts);
        mockMvc.perform(get("/app/account/accounts"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id").value(account.getId().toString()))
                .andExpect(jsonPath("$[0].accountNumber").value(account.getAccountNumber()))
                .andExpect(jsonPath("$[0].type").value(account.getType().toString()))
                .andExpect(jsonPath("$[0].status").value(account.getStatus().toString()))
                .andExpect(jsonPath("$[0].balance").value(account.getBalance().floatValue()))
                .andExpect(jsonPath("$[0].currencyCode").value(account.getCurrencyCode().toString()))
                .andExpect(jsonPath("$[0].createdAt").value(account.getCreatedAt().toString()))
                .andExpect(jsonPath("$[0].updatedAt").value(account.getUpdatedAt().toString()));
    }

    @Test
    void getAccountAndClientAndMangerTest() throws Exception {
        AccountDto accountDto = DtoCreator.getAccountDto();
        when(accountService.getACMId(account.getId())).thenReturn(accountDto);
        mockMvc.perform(get("/app/account/account_client_manager/{id}", account.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(accountDto.getId())))
                .andExpect(jsonPath("$.accountNumber", is(accountDto.getAccountNumber())))
                .andExpect(jsonPath("$.firstName", is(accountDto.getFirstName())))
                .andExpect(jsonPath("$.lastName", is(accountDto.getLastName())))
                .andExpect(jsonPath("$.status", is(accountDto.getStatus().toString())));

    }

    @Test
    void getAccountByIDTest() throws Exception {
        when(accountService.getAccById(account.getId())).thenReturn(account);
        mockMvc.perform(get("/app/account/{id}", account.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(account.getId().toString())))
                .andExpect(jsonPath("$.accountNumber", is(account.getAccountNumber())))
                .andExpect(jsonPath("$.type", is(account.getType().toString())))
                .andExpect(jsonPath("$.status", is(account.getStatus().toString())))
                .andExpect(jsonPath("$.balance", is(account.getBalance().doubleValue())))
                .andExpect(jsonPath("$.currencyCode", is(account.getCurrencyCode().toString())))
                .andExpect(jsonPath("$.createdAt", is(account.getCreatedAt().toString())))
                .andExpect(jsonPath("$.updatedAt", is(account.getUpdatedAt().toString())));
    }

    @Test
    void findAccountByAccountNumberTest() throws Exception {
        String accountNumber = "123456789";
        Account account = new Account();
        account.setId(UUID.fromString("91384699-c928-11ee-87e5-00155d26ef58"));
        account.setAccountNumber(accountNumber);
        account.setType(AccountTypeStatus.BUSINESS_ACCOUNT);
        account.setStatus(AccountStatus.ACTIVE);
        account.setBalance(new BigDecimal("2222.00"));
        account.setCurrencyCode(AccountCurrencyCode.EUR);
        account.setCreatedAt(LocalDate.of(2024, Month.FEBRUARY, 11));
        account.setUpdatedAt(LocalDate.of(2024, Month.FEBRUARY, 12));
        when(accountService.findAccountByAccountNumber(accountNumber)).thenReturn(account);
        mockMvc.perform(get("/app/account/account_number/{a_account_number}", accountNumber))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(account.getId().toString())))
                .andExpect(jsonPath("$.accountNumber", is(account.getAccountNumber())))
                .andExpect(jsonPath("$.type", is(account.getType().toString())))
                .andExpect(jsonPath("$.status", is(account.getStatus().toString())))
                .andExpect(jsonPath("$.balance", is(account.getBalance().doubleValue())))
                .andExpect(jsonPath("$.currencyCode", is(account.getCurrencyCode().toString())))
                .andExpect(jsonPath("$.createdAt", is(account.getCreatedAt().toString())))
                .andExpect(jsonPath("$.updatedAt", is(account.getUpdatedAt().toString())));
    }
}