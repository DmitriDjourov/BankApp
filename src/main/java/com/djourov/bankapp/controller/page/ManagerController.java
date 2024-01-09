package com.djourov.bankapp.controller.page;

import com.djourov.bankapp.entity.Manager;
import com.djourov.bankapp.service.impl.ManagerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/app/manager")
@RequiredArgsConstructor
public class ManagerController {
    private final ManagerServiceImpl managerServiceImpl;

    @GetMapping("/managers")//http:/localhost:8080/app/manager/managers
    public List<Manager> getAllManagers() {
        return managerServiceImpl.getAllManagers();
    }
}
