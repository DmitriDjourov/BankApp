package com.djourov.bankapp.service.impl;

import com.djourov.bankapp.dto.AccountDto;
import com.djourov.bankapp.entity.Account;
import com.djourov.bankapp.exception.ManagerForUpdateNotFoundException;
import com.djourov.bankapp.exception.message.ErrorMessages;
import com.djourov.bankapp.mapper.AccountMapper;
import com.djourov.bankapp.repository.AccountRepository;
import com.djourov.bankapp.service.interf.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Account getAccById(UUID id) {
        return accountRepository.getReferenceById(id);
    }

    @Override
    public Account findAccountByAccountNumber(String a_account_number) {
        return accountRepository.findAccountByAccountNumber(a_account_number);
    }

    @Override
    public AccountDto getACMId(UUID id) {
        Account entity = accountRepository.findById(id).orElseThrow(() -> new ManagerForUpdateNotFoundException(ErrorMessages.NO_MANAGER_WITH_ID, id));
        return accountMapper.toDto(entity);
    }

}
