package com.djourov.bankapp.entity;

import com.djourov.bankapp.entity.enums.AgreementInterestRateStatus;
import com.djourov.bankapp.entity.enums.AgreementStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "Agreement")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Agreement {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ag_id")
    private UUID id;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "ag_interest_rate")
    private AgreementInterestRateStatus interestRate;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "ag_status")
    private AgreementStatus status;

    @Column(name = "ag_sum")
    private BigDecimal sum;

    @Column(name = "ag_create_at")
    private LocalDate createdAt;

    @Column(name = "ag_update_at")
    private LocalDate updatedAt;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {MERGE, PERSIST, REFRESH})
    @JoinColumn(name = "ag_account_id", referencedColumnName = "a_id")
    private Account accountId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {MERGE, PERSIST, REFRESH})
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
