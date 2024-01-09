package com.djourov.bankapp.controller;

import com.djourov.bankapp.entity.Account;
import com.djourov.bankapp.service.impl.AccountServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/app/accounts")
@RequiredArgsConstructor
public class AccountController {
    private final AccountServiceImpl accountServiceImpl;
    @GetMapping("/")
    public List<Account> getAllAccounts(){
        return accountServiceImpl.getAllAccounts();
    }
}
