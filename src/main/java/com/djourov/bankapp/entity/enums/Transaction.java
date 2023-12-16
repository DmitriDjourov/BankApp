package com.djourov.bankapp.entity.enums;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@AllArgsConstructor
public class Transaction {
		private final UUID id;
		private int type;
		private BigDecimal amount;
		private String description;
		private LocalDate created_at;
		private Account debit_account_id;
		private Account credit_account_id;

		@Override
		public boolean equals(Object o) {
				if (this == o) return true;
				if (o == null || getClass() != o.getClass()) return false;
				Transaction that = (Transaction) o;
				return Objects.equals(id, that.id);
		}

		@Override
		public int hashCode() {
				return Objects.hash(id);
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
