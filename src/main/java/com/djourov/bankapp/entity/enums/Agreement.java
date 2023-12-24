package com.djourov.bankapp.entity.enums;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "Agreements")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Agreement {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ag_id")
    private UUID id;

    @Column(name = "ag_interest_rate")
    private double interest_rate;

    @Column(name = "ag_status")
    private int status;

    @Column(name = "ag_sum")
    private BigDecimal sum;

    @Column(name = "ag_created_at")
    private LocalDate created_at;

    @Column(name = "ag_updated_at")
    private LocalDate updated_at;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {MERGE, PERSIST, REFRESH})
    @JoinColumn(name = "ag_account_id", referencedColumnName = "a_id")
    private Account account_id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {MERGE, PERSIST, REFRESH})
    @JoinColumn(name = "ag_product_id", referencedColumnName = "p_id")
    private Product product_id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agreement agreement = (Agreement) o;
        return Objects.equals(id, agreement.id) && Objects.equals(product_id, agreement.product_id) && Objects.equals(account_id, agreement.account_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, product_id, account_id);
    }

    @Override
    public String toString() {
        return "Agreement{" +
                       "id=" + id +
                       ", interest_rate=" + interest_rate +
                       ", status=" + status +
                       ", sum=" + sum +
                       ", created_at=" + created_at +
                       ", updated_at=" + updated_at +
                       ", product_id=" + product_id +
                       ", account_id=" + account_id +
                       '}';
    }
}
