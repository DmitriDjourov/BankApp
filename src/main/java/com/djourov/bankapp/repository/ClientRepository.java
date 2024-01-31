package com.djourov.bankapp.repository;

import com.djourov.bankapp.entity.Client;
import com.djourov.bankapp.entity.enums.ClientStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ClientRepository extends JpaRepository<Client, UUID> {
    @Query("select c from Client c where c.status = :status")
    List<Client> findClientByStatus(ClientStatus status);
}

