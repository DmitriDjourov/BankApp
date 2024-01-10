package com.djourov.bankapp.controller.page;

import com.djourov.bankapp.entity.Manager;
import com.djourov.bankapp.service.interf.ManagerService;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
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
//    @GetMapping("/{id}") // localhost:8080/app/manager/ef62047b-afdf-11ee-a962-00ffe0e1a544
//    public Manager getManagerById(@PathVariable("id") UUID id) {
//        return managerService.getManagerById(id);
//    }
}
