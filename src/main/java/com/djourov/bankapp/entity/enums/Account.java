package com.djourov.bankapp.entity.enums;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@AllArgsConstructor
public class Account {
		private final UUID id;
		private String accountNumber;
		private int type;
		private int status;
		private BigDecimal balance;
		private int currency_code;
		private LocalDate created_at;
		private LocalDate updated_at;
		private Client client;

		@Override
		public boolean equals(Object o) {
				if (this == o) {
						return true;
				}
				if (o == null || getClass() != o.getClass()) return false;
				Account that = (Account) o;
				return Objects.equals(this.id, that.id);
		}

		@Override
		public int hashCode() {
				return Objects.hash(id);
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
