package com.djourov.bankapp.entity;

import com.djourov.bankapp.entity.enums.ClientStatus;
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
@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "Client")

public class Client {
    @Id
    @UuidGenerator
    @Column(name = "c_id")
    private UUID id;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "c_status")
    private ClientStatus status;

    @Column(name = "c_tax_code")//налоговый номер
    private String taxCode;

    @Column(name = "c_first_name")
    private String firstName;

    @Column(name = "c_last_name")
    private String lastName;

    @Column(name = "c_email")
    private String email;

    @Column(name = "c_address")
    private String address;

    @Column(name = "c_phone")
    private String phone;

    @Column(name = "c_create_at")
    private LocalDate createdAt;

    @Column(name = "c_update_at")
    private LocalDate updatedAt;

    @ManyToOne()
    @JoinColumn(name = "c_manager_id", referencedColumnName = "m_id")
    private Manager manager;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id) && Objects.equals(taxCode, client.taxCode) && Objects.equals(manager, client.manager);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, taxCode, manager);
    }

    @Override
    public String toString() {
        return "Client{" +
                       "id=" + id +
                       ", status=" + status +
                       ", taxCode='" + taxCode + '\'' +
                       ", firstName='" + firstName + '\'' +
                       ", lastName='" + lastName + '\'' +
                       ", email='" + email + '\'' +
                       ", address='" + address + '\'' +
                       ", phone='" + phone + '\'' +
                       ", createdAt=" + createdAt +
                       ", updatedAt=" + updatedAt +
                       ", manager=" + manager +
                       '}';
    }
}
