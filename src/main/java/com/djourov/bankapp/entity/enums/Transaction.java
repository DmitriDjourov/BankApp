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

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "transaction")

public class Transaction {
		@Id
		@GeneratedValue(strategy = GenerationType.UUID)
		@Column(name = "t_id")
		private UUID id;

		@Column(name = "t_type")
		private int type;

		@Column(name = "t_amount")
		private BigDecimal amount;

		@Column(name = "t_description")
		private String description;

		@Column(name = "t_created_at")
		private LocalDate created_at;

		private Account debit_account_id;

		private Account credit_account_id;

		@Override
		public boolean equals(Object o) {
				if (this == o) return true;
				if (o == null || getClass() != o.getClass()) return false;
				Transaction that = (Transaction) o;
				return Objects.equals(id, that.id) && Objects.equals(created_at, that.created_at) && Objects.equals(credit_account_id, that.credit_account_id);
		}

		@Override
		public int hashCode() {
				return Objects.hash(id, created_at, credit_account_id);
		}

		@Override
		public String toString() {
				return "Transaction{" +
						       "id=" + id +
						       ", type=" + type +
						       ", amount=" + amount +
						       ", description='" + description + '\'' +
						       ", created_at=" + created_at +
						       ", debit_account_id=" + debit_account_id +
						       ", credit_account_id=" + credit_account_id +
						       '}';
		}
}
