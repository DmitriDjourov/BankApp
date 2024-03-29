package com.djourov.bankapp.entity;

import com.djourov.bankapp.entity.enums.AccountCurrencyCode;
import com.djourov.bankapp.entity.enums.AccountStatus;
import com.djourov.bankapp.entity.enums.AccountTypeStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.type.SqlTypes;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Account")

public class Account {
    @Id
    @UuidGenerator
    @Column(name = "a_id")
    private UUID id;

    @Column(name = "a_account_number")
    private String accountNumber;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "a_type")
    private AccountTypeStatus type;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "a_status")
    private AccountStatus status;

    @Column(name = "a_balance")
    private BigDecimal balance;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "a_currency_code")
    private AccountCurrencyCode currencyCode;

    @Column(name = "a_create_at")
    private LocalDate createdAt;

    @Column(name = "a_update_at")
    private LocalDate updatedAt;

    @ManyToOne()
    @JsonBackReference("fk_account_client_id")
    @JoinColumn(name = "a_client_id", referencedColumnName = "c_id")
    private Client client;

    @OneToMany(mappedBy = "debitAccountId")
    @JsonManagedReference("fk_transaction_debit_account")
    private List<Transaction> debitTransactions;

    @OneToMany(mappedBy = "creditAccountId")
    @JsonManagedReference("fk_transaction_credit_account")
    private List<Transaction> creditTransactions;

    @OneToMany(mappedBy = "id")
    @JsonManagedReference("fk_agreement_account")
    private List<Agreement> agreements;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id) && Objects.equals(accountNumber, account.accountNumber) && Objects.equals(client, account.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accountNumber, client);
    }

    @Override
    public String toString() {
        return "Account{" +
                       "id=" + id +
                       ", accountNumber='" + accountNumber + '\'' +
                       ", type=" + type +
                       ", status=" + status +
                       ", balance=" + balance +
                       ", currencyCode=" + currencyCode +
                       ", createdAt=" + createdAt +
                       ", updatedAt=" + updatedAt +
                       ", client=" + client +
                       ", debitTransactions=" + debitTransactions +
                       ", creditTransactions=" + creditTransactions +
                       ", agreements=" + agreements +
                       '}';
    }
}
