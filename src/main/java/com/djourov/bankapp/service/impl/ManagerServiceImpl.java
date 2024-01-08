package com.djourov.bankapp.service.impl;

import com.djourov.bankapp.entity.Manager;
import com.djourov.bankapp.repository.ManagerRepository;
import com.djourov.bankapp.service.interf.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ManagerServiceImpl implements ManagerService {

    private final ManagerRepository managerRepository;

    @Override
    public Manager getManagerAllById(String id) {
        return managerRepository.getReferenceById(UUID.fromString(id));
    }

    @Override
    public Manager getAllManagers() {
        return (Manager) managerRepository.findAll();
    }
}
