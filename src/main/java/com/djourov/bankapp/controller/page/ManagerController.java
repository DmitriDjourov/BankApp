package com.djourov.bankapp.controller.page;

import com.djourov.bankapp.entity.Manager;
import com.djourov.bankapp.service.interf.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bankapp")//http://localhost:8080//bankapp
public class ManagerController {
    private final ManagerService managerService;
    @GetMapping("/manager/{id}")//http:localhost:8080/bankapp/manager/1763f054-5393-11ee-8c99-0242ac120002
    public Manager getManagerById(@PathVariable("id") String id){
        return managerService.getManagerAllById(id);
    }
    @GetMapping("/managers")
    public Manager getAllManagers(){
        return null;
    }
}
