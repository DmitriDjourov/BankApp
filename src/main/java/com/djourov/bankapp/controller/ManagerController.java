package com.djourov.bankapp.controller;

import com.djourov.bankapp.entity.Manager;
import com.djourov.bankapp.service.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/app/managers")
@RequiredArgsConstructor
public class ManagerController {
    private final ManagerService managerService;

    @GetMapping("/")
    public List<Manager> getAllManagers(){
        return  managerService.getAllManagers();
    }
}
