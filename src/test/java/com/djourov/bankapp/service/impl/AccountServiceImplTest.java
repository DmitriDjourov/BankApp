package com.djourov.bankapp.service.impl;

import com.djourov.bankapp.dto.AccountDto;
import com.djourov.bankapp.entity.Account;
import com.djourov.bankapp.exception.AccountByIdNotFoundException;
import com.djourov.bankapp.mapper.AccountMapper;
import com.djourov.bankapp.repository.AccountRepository;
import com.djourov.bankapp.util.DtoCreator;
import com.djourov.bankapp.util.EntityCreator;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.clearInvocations;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AccountServiceImplTest {
    @Mock
    private AccountRepository accountRepository;
    @Mock
    private AccountMapper accountMapper;
    @InjectMocks
    private AccountServiceImpl accountService;

    @AfterEach
    public void clearMocks() {
        clearInvocations(accountMapper, accountMapper);
    }

    @Test
    void getAllAccounts() {
        List<Account> accountList = new ArrayList<>();
        accountList.add(EntityCreator.getAccount());
        when(accountRepository.findAll()).thenReturn(accountList);
        List<Account> result = accountService.getAllAccounts();
        Assertions.assertNotNull(result);
    }

    @Test
    void getAccById() {
        Account account = EntityCreator.getAccount();
        when(accountRepository.getReferenceById(account.getId())).thenReturn(account);
        Account result = accountService.getAccById(account.getId());
        Assertions.assertEquals(account, result);
    }

    @Test
    void findAccountByAccountNumber() {
        Account account = EntityCreator.getAccount();
        when(accountRepository.findAccountByAccountNumber(account.getAccountNumber())).thenReturn(account);
        Account result = accountService.findAccountByAccountNumber((account.getAccountNumber()));
        Assertions.assertEquals(account, result);
    }

    @Test
    void getACMIdTest() {
        Account account = EntityCreator.getAccount();
        AccountDto accountDto = DtoCreator.getAccountDto();
        when(accountRepository.findById(account.getId())).thenReturn(Optional.of(account));
        when(accountMapper.toDto(account)).thenReturn(accountDto);

        AccountDto actualAccountDto = accountService.getACMId(account.getId());
        Assert.assertEquals(actualAccountDto, accountDto);
    }

    @Test
    void getACMId_AccountDTOThrowException() {
        UUID id = EntityCreator.getAccount().getId();
        when(accountRepository.findById(id)).thenReturn(Optional.empty());
        Assertions.assertThrows(AccountByIdNotFoundException.class, () -> accountService.getACMId(id));
    }
}