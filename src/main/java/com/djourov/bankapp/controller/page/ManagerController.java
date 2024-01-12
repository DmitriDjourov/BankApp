package com.djourov.bankapp.controller.page;

import com.djourov.bankapp.entity.Manager;
import com.djourov.bankapp.entity.enums.ManagerStatus;
import com.djourov.bankapp.service.interf.ManagerService;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/app/manager")
@RequiredArgsConstructor
public class ManagerController {
    private final ManagerService managerService;

    @GetMapping("/managers") // http:/localhost:8080/app/manager/managers
    public List<Manager> getAllManagers() {
        return managerService.getAllManagers();
    }

    @GetMapping("/{id}")// localhost:8080/app/manager/
    public Manager getManagerById(@PathVariable("id") UUID id) {
        Manager manager = managerService.getManagerById(id);
        return (Manager) Hibernate.unproxy(manager);
    }

    @GetMapping("/upd/to_senior/{id}")//localhost:8080/app/manager/upd/to_senior/779d7b80-b0c4-11ee-a812-00ffe0e1a544
    public String updateManagerStatusSeniorById(@PathVariable("id") UUID id) {
        boolean isUpdated = managerService.updateManagerStatusSeniorById(id);

        if (isUpdated) {
            return String.valueOf(new ResponseEntity<>("Manager status updated to SENIOR_MANAGER", HttpStatus.OK));
        } else {
            return String.valueOf(new ResponseEntity<>("Manager not found with id: " + id, HttpStatus.NOT_FOUND));
        }
    }
}
