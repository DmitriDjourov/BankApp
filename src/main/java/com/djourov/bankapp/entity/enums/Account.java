package com.djourov.bankapp.entity.enums;

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
@Table(name = "account")

public class Account {
		@Id
		@GeneratedValue(strategy = GenerationType.UUID)
		@Column(name = "a_id")
		private UUID id;

		@Column(name = "a_account_number")
		private String accountNumber;

		@Column(name = "a_type")
		private int type;

		@Column(name = "a_status")
		private int status;

		@Column(name = "a_balance")
		private BigDecimal balance;

		@Column(name = "a_currency_code")
		private int currency_code;

		@Column(name = "a_created_at")
		private LocalDate created_at;

		@Column(name = "a_updated_at")
		private LocalDate updated_at;

		@OneToOne(mappedBy = "c_id", orphanRemoval = true, cascade = {MERGE, PERSIST, REFRESH}, fetch = FetchType.LAZY)
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
						       ", currency_code=" + currency_code +
						       ", created_at=" + created_at +
						       ", updated_at=" + updated_at +
						       ", client=" + client +
						       '}';
		}
}
