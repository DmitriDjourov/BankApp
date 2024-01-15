package com.djourov.bankapp.service.interf;

import com.djourov.bankapp.entity.Manager;

import java.util.List;
import java.util.UUID;

public interface ManagerService {
    List<Manager> getAllManagers();

    Manager getManagerById(UUID id);

    boolean updateManagerStatusSeniorById(UUID id);

    Manager postCreateManager(Manager manager);

    Manager deleteById(UUID id);

    Manager updById(UUID id);
}

