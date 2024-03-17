package com.djourov.bankapp.repository;

import com.djourov.bankapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface UserRepository  extends JpaRepository<User, UUID> {
    // User findByLogin(String login);

    Optional<User> findByUsername(String username);
    boolean existsByUsername(String usernabe);
//    boolean existsByEmail(String email);
}
