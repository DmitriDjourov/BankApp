package com.djourov.bankapp.service.interf;

import com.djourov.bankapp.dto.ManagerDTO;
import com.djourov.bankapp.entity.Manager;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

public interface ManagerService {
    List<Manager> getAllManagers();

    Manager getManagerById(UUID id);

    Manager postCreateManager(Manager manager);

    Manager deleteById(UUID id);

    Manager updateManagerStatusSeniorById(UUID id);

    Manager getManagerReferenceById(UUID id);

    ManagerDTO getManagerByIdFirstLastName(UUID id);
}

