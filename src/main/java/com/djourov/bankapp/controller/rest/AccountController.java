package com.djourov.bankapp.controller.rest;

import com.djourov.bankapp.dto.AccountDto;
import com.djourov.bankapp.entity.Account;
import com.djourov.bankapp.service.interf.AccountService;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/app/account")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @GetMapping("/accounts")//localhost:8080/app/account/accounts
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/account_client_manager/{id}")// localhost:8080/app/account/account_client_manager/30633730-6166-6131-2d63-3635342d3437
    public AccountDto getAccountAndClientAndManger(@PathVariable("id") UUID id){
        return accountService.getACMId(id);
    }

    @GetMapping("/{id}")//localhost:8080/app/account/30633730-6166-6131-2d63-3635342d3437(не работает)
    public Account getAccountByID(@PathVariable("id") UUID id) {
        Account account = accountService.getAccById(id);
        return (Account) Hibernate.unproxy(account);
    }
    @GetMapping("/account_number/{a_account_number}")//localhost:8080/app/account/account_number/123456789
    public Account findAccountByAccountNumber(@PathVariable("a_account_number") String a_account_number) {
        return accountService.findAccountByAccountNumber(a_account_number);
    }
}
