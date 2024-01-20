package com.djourov.bankapp.controller.page;

import com.djourov.bankapp.entity.Manager;
import com.djourov.bankapp.service.interf.ManagerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/pages/manager")
public class ManagerPageController {
    private final ManagerService managerService;

    public ManagerPageController(ManagerService managerService) {
        this.managerService = managerService;
    }

    // шаблонизатор Thymeleaf
    @GetMapping("/managers") // localhost:8080/pages/manager/managers
    public String getAllManagers(Model model) {
        List<Manager> managers = managerService.getAllManagers();
        model.addAttribute("managersForModel", managers);
        return "managers";
    }

    @GetMapping("/{id}") // localhost:8080/pages/manager/b407a7f7-b49f-11ee-9c53-00ffe0e1a544
    public String getManagerById(@PathVariable("id") UUID id, Model model) {
        Manager manager = managerService.getManagerById(id);
        model.addAttribute("managerByIdForModel", manager);
        return "manager";
    }
}
