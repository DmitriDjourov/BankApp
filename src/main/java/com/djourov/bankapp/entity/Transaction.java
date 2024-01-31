package com.djourov.bankapp.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.sql.SQLType;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "Transaction")

public class Transaction {
    @Id
    @UuidGenerator // @GeneratedValue(strategy = SQLType.CHAR)
    @Column(name = "t_id")
    private UUID id;

    @Column(name = "t_type")
    private int type;

    @Column(name = "t_amount")
    private BigDecimal amount;

    @Column(name = "t_description")
    private String description;

    @Column(name = "t_create_at")
    private LocalDate createAt;

    @ManyToOne()
    @JsonBackReference("fk_transaction_debit_account")
    @JoinColumn(name = "t_debit_account_id", referencedColumnName = "a_id")
    private Account debitAccountId;

    @ManyToOne()
    @JsonBackReference("fk_transaction_credit_account")
    @JoinColumn(name = "t_credit_account_id", referencedColumnName = "a_id")
    private Account creditAccountId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(id, that.id) && Objects.equals(createAt, that.createAt) && Objects.equals(creditAccountId, that.creditAccountId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createAt, creditAccountId);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                       "id=" + id +
                       ", type=" + type +
                       ", amount=" + amount +
                       ", description='" + description + '\'' +
                       ", createAt=" + createAt +
                       ", debitAccountId=" + debitAccountId +
                       ", creditAccountId=" + creditAccountId +
                       '}';
    }
}
