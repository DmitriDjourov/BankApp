package com.djourov.bankapp.service.impl;

import com.djourov.bankapp.dto.AccountDto;
import com.djourov.bankapp.entity.Account;
import com.djourov.bankapp.exception.AccountByIdNotFoundException;
import com.djourov.bankapp.mapper.AccountMapper;
import com.djourov.bankapp.repository.AccountRepository;
import com.djourov.bankapp.service.interf.AccountService;
import com.djourov.bankapp.util.DtoCreator;
import com.djourov.bankapp.util.EntityCreator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AccountServiceImplTest {
    @Mock
    AccountRepository accountRepository;
    AccountService accountService;
    @Mock
    AccountMapper accountMapper;

    @BeforeEach
    void init() {
        accountService = new AccountServiceImpl(accountRepository, accountMapper);
    }

    @Test
    void getACMId_ShouldReturnAAccount() {
        UUID id = EntityCreator.getAccount().getId();
        Account account = new Account(id,
                EntityCreator.getAccount().getAccountNumber(),
                EntityCreator.getAccount().getType(),
                EntityCreator.getAccount().getStatus(),
                EntityCreator.getAccount().getBalance(),
                EntityCreator.getAccount().getCurrencyCode(),
                EntityCreator.getAccount().getCreatedAt(),
                EntityCreator.getAccount().getUpdatedAt(),
                null, null, null, null);
        AccountDto accountDto = new AccountDto(DtoCreator.getAccountDto().getId(),
                DtoCreator.getAccountDto().getAccountNumber(),
                DtoCreator.getAccountDto().getFirstName(),
                DtoCreator.getAccountDto().getLastName(),
                DtoCreator.getAccountDto().getStatus());
        when(accountRepository.findById(id)).thenReturn(Optional.of(account));
        var result = accountService.getACMId(id);
        Assertions.assertNotNull(result);
        //Assertions.assertEquals(accountDto, result);
    }

    @Test
    void getACMId_ShouldAccountDTOThrowException() {
        UUID id = EntityCreator.getAccount().getId();
        when(accountRepository.findById(id)).thenReturn(Optional.empty());
        Assertions.assertThrows(AccountByIdNotFoundException.class, () -> accountService.getACMId(id));
    }
}