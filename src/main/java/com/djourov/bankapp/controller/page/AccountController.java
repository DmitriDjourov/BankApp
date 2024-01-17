package com.djourov.bankapp.controller.page;

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

    @GetMapping("/accounts")
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/{id}")//localhost:8080/app/account/30633730-6166-6131-2d63-3635342d3437(не работает)
    public Account getAccountByID(@PathVariable("id") UUID id) {
        Account account = accountService.getAccById(id);
        return (Account) Hibernate.unproxy(account);
    }
    @GetMapping("/account_number/{a_account_number}")//http:/localhost:8080/app/account/account_number/123456789
    public Account findAccountByAccountNumber(@PathVariable("a_account_number") String a_account_number) {
        return accountService.findAccountByAccountNumber(a_account_number);
    }
}
