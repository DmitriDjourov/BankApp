package com.djourov.bankapp.service.impl;

import com.djourov.bankapp.entity.Manager;
import com.djourov.bankapp.entity.enums.ManagerStatus;
import com.djourov.bankapp.exception.message.ErrorMessage;
import com.djourov.bankapp.exception.ManagerForDeleteNotFoundException;
import com.djourov.bankapp.exception.ManagerForUpdateNotFoundException;
import com.djourov.bankapp.repository.ManagerRepository;
import com.djourov.bankapp.service.interf.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
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

    /**
     * localhost:8080/app/manager/createManager
     * post postman Body raw JSON
     * {
     * "firstName": "Patrik",
     * "lastName": "Krolikoff",
     * "status": "CREDIT_MANAGER"
     * }
     */
    @Override
    public Manager postCreateManager(Manager manager) {
        manager.setId(null);
        manager.setCreatedAt(LocalDate.now());
        manager.setUpdatedAt(null);
        return managerRepository.save(manager);
    }

    /**
     * работает в postman как DELETE
     * localhost:8080/app/manager/del/799beb00-bfc7-4b10-a5c5-17d9a5be0472-взять из базы
     */
    @Override
    public Manager deleteById(UUID id) {
        Manager manager = managerRepository.findById(id)
                                  .orElseThrow(() -> new ManagerForDeleteNotFoundException(ErrorMessage.NO_MANAGER_DEL_WITH_ID));
        if (manager != null) {
            managerRepository.deleteById(id);
        }
        return manager;
    }

    /**
     * работает в postman как PUT
     * localhost:8080/app/manager/upd/manager_status_senior/83188565-b3f4-11ee-9c53-00ffe0e1a544-взять из базы
     */
    @Override
    public Manager updateManagerStatusSeniorById(UUID id) {
        Manager manager = managerRepository.findById(id)
                                  .orElseThrow(() -> new ManagerForUpdateNotFoundException(ErrorMessage.NO_MANAGER_UPD_WITH_ID));
        if (manager != null) {
            manager.setStatus(ManagerStatus.SENIOR_MANAGER);
            managerRepository.save(manager);
        }
        return manager;
    }

}
