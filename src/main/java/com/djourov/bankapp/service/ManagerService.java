package com.djourov.bankapp.service;

import com.djourov.bankapp.entity.Manager;
import com.djourov.bankapp.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerService {
    private final ManagerRepository repository;

    public ManagerService(ManagerRepository repository) {
        this.repository = repository;
    }

    public List<Manager> getAllManagers(){
        return repository.findAll();
    }
}
