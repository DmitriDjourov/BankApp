package com.djourov.bankapp.service.impl;

import com.djourov.bankapp.entity.Account;
import com.djourov.bankapp.repository.TestRepository;
import com.djourov.bankapp.service.interf.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {

    private final TestRepository testRepository;

    @Override
    public Account getAccById(String id) {
        return testRepository.getAccountById(UUID.fromString(id));
    }
}
