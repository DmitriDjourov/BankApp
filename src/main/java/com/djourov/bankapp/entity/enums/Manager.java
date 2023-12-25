package com.djourov.bankapp.entity.enums;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "m_id")
    private UUID id;

    @Column(name = "m_first_name")
    private String first_name;

    @Column(name = "m_last_name")
    private String last_name;

    @Column(name = "m_status")
    private int status;

    @Column(name = "m_create_at")
    private LocalDate created_at;

    @Column(name = "m_update_at")
    private LocalDate updated_at;

//    @OneToOne(mappedBy = "Client", fetch = FetchType.LAZY,
//            orphanRemoval = true, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
//    private Client client;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manager manager = (Manager) o;
        return Objects.equals(id, manager.id) && Objects.equals(created_at, manager.created_at);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, created_at);
    }

    @Override
    public String toString() {
        return "Manager{" +
                       "id=" + id +
                       ", first_name='" + first_name + '\'' +
                       ", last_name='" + last_name + '\'' +
                       ", status=" + status +
                       ", created_at=" + created_at +
                       ", updated_at=" + updated_at +
                       '}';
    }
}