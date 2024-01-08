package com.djourov.bankapp.service.interf;

import com.djourov.bankapp.entity.Manager;

public interface ManagerService {
    Manager getManagerAllById(String id);

    Manager getAllManagers();
}
