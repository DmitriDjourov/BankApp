package com.djourov.bankapp.repository;

import com.djourov.bankapp.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ClientRepository extends JpaRepository<Client, UUID> {
    @Query("SELECT a.lastName, a.firstName, a.phone, a.status FROM Client a WHERE a.status = 0")
    List<Client> findClientsWithZeroStatus();
}
