package com.djourov.bankapp.entity;

import com.djourov.bankapp.entity.enums.ManagerStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "Manager")

public class Manager {
    @Id
    @UuidGenerator
    @Column(name = "m_id")
    private UUID id;

    @Column(name = "m_first_name")
    private String firstName;

    @Column(name = "m_last_name")
    private String lastName;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "m_status")
    private ManagerStatus status;

    @Column(name = "m_create_at")
    private LocalDate createdAt;

    @Column(name = "m_update_at")
    private LocalDate updatedAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manager manager = (Manager) o;
        return Objects.equals(id, manager.id) && Objects.equals(createdAt, manager.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdAt);
    }

    @Override
    public String toString() {
        return "Manager{" +
                       "id=" + id +
                       ", firstName='" + firstName + '\'' +
                       ", lastName='" + lastName + '\'' +
                       ", status=" + status +
                       ", createdAt=" + createdAt +
                       ", updatedAt=" + updatedAt +
                       '}';
    }
}