package com.djourov.bankapp.service.interf;

import com.djourov.bankapp.entity.Account;

import java.util.List;
import java.util.UUID;

public interface AccountService {
    List<Account> getAllAccounts();
    Account getAccById(UUID id);
    Account findAccountByAccountNumber(String a_account_number);
}
