package com.djourov.bankapp.controller.page;

import com.djourov.bankapp.entity.Manager;
import com.djourov.bankapp.entity.enums.ManagerStatus;
import com.djourov.bankapp.service.interf.ManagerService;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/app/manager")
@RequiredArgsConstructor
public class ManagerController {
    private final ManagerService managerService;

    @GetMapping("/managers") // localhost:8080/app/manager/managers
    public List<Manager> getAllManagers() {
        return managerService.getAllManagers();
    }

    @GetMapping("/{id}")// localhost:8080/app/manager/
    public Manager getManagerById(@PathVariable("id") UUID id) {
        Manager manager = managerService.getManagerById(id);
        return (Manager) Hibernate.unproxy(manager);
    }

    @GetMapping("/upd/to_senior/{id}")//localhost:8080/app/manager/upd/to_senior/
    public String updateManagerStatusSeniorById(@PathVariable("id") UUID id) {
        boolean isUpdated = managerService.updateManagerStatusSeniorById(id);

        if (isUpdated) {
            return String.valueOf(new ResponseEntity<>("Manager status updated to SENIOR_MANAGER", HttpStatus.OK));
        } else {
            return String.valueOf(new ResponseEntity<>("Manager not found with id: " + id, HttpStatus.NOT_FOUND));
        }
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
    @PostMapping("/createManager")// localhost:8080/app/manager/createManager
    public Manager postCreateManager(@RequestBody Manager manager) {
        return managerService.postCreateManager(manager);
    }
    /**
     * работает в postman как DELETE
     * localhost:8080/app/manager/del/799beb00-bfc7-4b10-a5c5-17d9a5be0472-взять из базы
     */
    @DeleteMapping("/del/{id}")// localhost:8080/app/manager/del/
    public Manager deleteManagerById(@PathVariable UUID id) {
        return managerService.deleteById(id);
    }
    /**
     * работает в postman как PUT
     * localhost:8080/app/manager/upd/manager_status_senior/83188565-b3f4-11ee-9c53-00ffe0e1a544-взять из базы
     */
    @PutMapping("/upd/manager_status_senior/{id}")//localhost:8080/app/manager/upd/manager_status_senior/
    public Manager updPutManagerById(@PathVariable UUID id) {
        return managerService.updById(id);
    }
}
