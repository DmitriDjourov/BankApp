package com.djourov.bankapp.repository;

import com.djourov.bankapp.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TestRepository extends JpaRepository<Account, UUID> {
    Account getAccountById(UUID id);
}

