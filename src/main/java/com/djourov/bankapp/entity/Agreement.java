package com.djourov.bankapp.entity;

import com.djourov.bankapp.entity.enums.AgreementStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "Agreement")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Agreement {
    @Id
    @UuidGenerator
    @Column(name = "ag_id")
    private UUID id;

    @Column(name = "ag_interest_rate")
    private BigDecimal interestRate;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "ag_status")
    private AgreementStatus status;

    @Column(name = "ag_sum")
    private BigDecimal sum;

    @Column(name = "ag_create_at")
    private LocalDate createdAt;

    @Column(name = "ag_update_at")
    private LocalDate updatedAt;

    @ManyToOne()
    @JoinColumn(name = "ag_account_id", referencedColumnName = "a_id")
    private Account accountId;

    @ManyToOne()
    @JoinColumn(name = "ag_product_id", referencedColumnName = "p_id")
    private Product productId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agreement agreement = (Agreement) o;
        return Objects.equals(id, agreement.id) && Objects.equals(productId, agreement.productId) && Objects.equals(accountId, agreement.accountId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productId, accountId);
    }

    @Override
    public String toString() {
        return "Agreement{" +
                       "id=" + id +
                       ", interest_rate=" + interestRate +
                       ", status=" + status +
                       ", sum=" + sum +
                       ", created_at=" + createdAt +
                       ", updated_at=" + updatedAt +
                       ", product_id=" + productId +
                       ", account_id=" + accountId +
                       '}';
    }
}
