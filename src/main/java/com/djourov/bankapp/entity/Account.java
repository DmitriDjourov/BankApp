package com.djourov.bankapp.entity;

import com.djourov.bankapp.entity.enums.AccountCurrencyCode;
import com.djourov.bankapp.entity.enums.AccountStatus;
import com.djourov.bankapp.entity.enums.AccountTypeStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

import static jakarta.persistence.CascadeType.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Account")

public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
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

    @OneToOne(cascade = {MERGE, PERSIST, REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "a_client_id", referencedColumnName = "c_id")
    private Client client;

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
                       ", name='" + accountNumber + '\'' +
                       ", type=" + type +
                       ", status=" + status +
                       ", balance=" + balance +
                       ", currency_code=" + currencyCode +
                       ", created_at=" + createdAt +
                       ", updated_at=" + updatedAt +
                       ", client=" + client +
                       '}';
    }
}
