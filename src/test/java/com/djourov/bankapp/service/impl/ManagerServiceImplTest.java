package com.djourov.bankapp.service.impl;

import com.djourov.bankapp.dto.ManagerDTO;
import com.djourov.bankapp.entity.Manager;
import com.djourov.bankapp.entity.enums.ManagerStatus;
import com.djourov.bankapp.exception.ManagerForDeleteNotFoundException;
import com.djourov.bankapp.exception.ManagerForUpdateNotFoundException;
import com.djourov.bankapp.exception.ManagerNotFoundException;
import com.djourov.bankapp.mapper.ManagerMapper;
import com.djourov.bankapp.repository.ManagerRepository;
import com.djourov.bankapp.util.DtoCreator;
import com.djourov.bankapp.util.EntityCreator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ManagerServiceImplTest {
    @Mock
    private ManagerRepository managerRepository;
    @Mock
    private ManagerMapper managerMapper;
    @InjectMocks
    private ManagerServiceImpl managerService;

    @AfterEach
    public void clearMocks() {
        clearInvocations(managerRepository, managerMapper);
    }

    private final Manager manager = EntityCreator.getManager();
    private final UUID id = EntityCreator.getManager().getId();

    @Test
    void getAllManagersTest() {
        List<Manager> managerList = new ArrayList<>();
        managerList.add(EntityCreator.getManager());
        when(managerRepository.findAll()).thenReturn(managerList);
        List<Manager> result = managerService.getAllManagers();
        Assertions.assertNotNull(result);
    }

    @Test
    void getManagerByIdTest() {
        when(managerRepository.findById(manager.getId())).thenReturn(Optional.of(manager));
        Manager result = managerService.getManagerById(manager.getId());
        Assertions.assertEquals(manager, result);
    }

    @Test
    void getMangerByIdExceptionTest() {
        when(managerRepository.findById(id)).thenReturn(Optional.empty());
        Assertions.assertThrows(ManagerNotFoundException.class, () -> managerService.getManagerById(id));
    }

    @Test
    void postCreateManagerTest() {
        when(managerRepository.save(any(Manager.class))).thenReturn(manager);
        Manager result = managerService.postCreateManager(manager);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(result, manager);
    }

    @Test
    void deleteByIdTest() {
        when(managerRepository.findById(manager.getId())).thenReturn(Optional.of(manager));
        Manager result = managerService.deleteById(manager.getId());
        verify(managerRepository, times(1)).deleteById(manager.getId());
        Assertions.assertEquals(manager, result);
    }

    @Test
    void deleteByIdExceptionTest() {
        when(managerRepository.findById(id)).thenReturn(Optional.empty());
        Assertions.assertThrows(ManagerForDeleteNotFoundException.class, () -> managerService.deleteById(id));
    }

    @Test
    void updateManagerStatusSeniorByIdTest() {
        when(managerRepository.findById(manager.getId())).thenReturn(Optional.of(manager));
        Manager result = managerService.updateManagerStatusSeniorById(manager.getId());
        Assertions.assertEquals(ManagerStatus.SENIOR_MANAGER, result.getStatus());
    }

    @Test
    void updateManagerStatusSeniorByIdExceptionTest() {
        when(managerRepository.findById(id)).thenReturn(Optional.empty());
        Assertions.assertThrows(ManagerForUpdateNotFoundException.class, () -> managerService.updateManagerStatusSeniorById(id));
    }

    @Test
    void getManagerReferenceByIdTest() {
        when(managerRepository.getReferenceById(manager.getId())).thenReturn(manager);
        Manager result = managerService.getManagerReferenceById(manager.getId());
        Assertions.assertEquals(manager, result);
    }

    @Test
    void getManagerByIdFirstLastNameTest() {
        ManagerDTO managerDTO = DtoCreator.getManagerDTO();
        when(managerRepository.findById(manager.getId())).thenReturn(Optional.of(manager));
        when(managerMapper.toDto(manager)).thenReturn(managerDTO);
        ManagerDTO actualManagerDto = managerService.getManagerByIdFirstLastName(manager.getId());
        Assertions.assertEquals(actualManagerDto, managerDTO);
    }

    @Test
    void getManagerByIdFirstLastNameExceptionTest() {
        when(managerRepository.findById(id)).thenReturn(Optional.empty());
        Assertions.assertThrows(ManagerNotFoundException.class, () -> managerService.getManagerByIdFirstLastName(id));
    }
}