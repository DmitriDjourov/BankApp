package com.djourov.bankapp.service.impl;

import com.djourov.bankapp.entity.Manager;
import com.djourov.bankapp.entity.enums.ManagerStatus;
import com.djourov.bankapp.repository.ManagerRepository;
import com.djourov.bankapp.service.interf.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ManagerServiceImpl implements ManagerService {

    private final ManagerRepository managerRepository;

    @Override
    public List<Manager> getAllManagers() {
        return managerRepository.findAll();
    }

    @Override
    public Manager getManagerById(UUID id) {
        return managerRepository.getReferenceById(id);
    }

    @Override
    public boolean updateManagerStatusSeniorById(UUID id) {
        Optional<Manager> optionalManager = managerRepository.findById(id);
        if (optionalManager.isPresent()) {
            Manager manager = optionalManager.get();
            manager.setStatus(ManagerStatus.SENIOR_MANAGER);
            managerRepository.save(manager);
            return true;
        } else {
            return false;// Запись с данным идентификатором не найдена
        }
    }
}