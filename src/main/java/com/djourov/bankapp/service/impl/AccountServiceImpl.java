package com.djourov.bankapp.service.impl;

import com.djourov.bankapp.entity.Account;
import com.djourov.bankapp.repository.AccountRepository;
import com.djourov.bankapp.service.interf.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }
}
