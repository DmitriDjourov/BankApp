package com.djourov.bankapp.controller.page;

import com.djourov.bankapp.entity.Account;
import com.djourov.bankapp.service.impl.AccountServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app/account")
@RequiredArgsConstructor
public class AccountController {
    private final AccountServiceImpl accountServiceImpl;

    @GetMapping("/accounts")
    public List<Account> getAllAccounts() {
        return accountServiceImpl.getAllAccounts();
    }

    @GetMapping("/account/{id}")//http:/localhost:8080/app/accounts/account/30633730-6166-6131-2d63-3635342d3437(не работает)
    public Account getAccountByID(@PathVariable("id") String id) {
        return accountServiceImpl.getAccById(id);
    }

    @GetMapping("/account_number/{a_account_number}")//http:/localhost:8080/app/accounts/account_number/123456789
    public Account findAccountByAccountNumber(@PathVariable("a_account_number") String a_account_number) {
        return accountServiceImpl.findAccountByAccountNumber(a_account_number);
    }
}
