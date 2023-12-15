package com.djourov.bankapp.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Builder
@AllArgsConstructor
@Data
public class Account {

		private final UUID id = UUID.randomUUID();
		private String name;
		private int type;
		private int status;
		private BigDecimal balance;
		private int currency_code;
		private LocalDate created_at;
		private LocalDate updated_at;
		private Client client;

		@Override
		public String toString() {
				return "Account{" +
						       "id=" + id +
						       ", name='" + name + '\'' +
						       ", type=" + type +
						       ", status=" + status +
						       ", balance=" + balance +
						       ", currency_code=" + currency_code +
						       ", created_at=" + created_at +
						       ", updated_at=" + updated_at +
						       ", client=" + client +
						       '}';
		}

		@Override
		public boolean equals(Object o) {
				if (this == o) return true;
				if (o == null || getClass() != o.getClass()) return false;
				Account account = (Account) o;
				return type == account.type && status == account.status && currency_code == account.currency_code && Objects.equals(id, account.id) && Objects.equals(name, account.name) && Objects.equals(balance, account.balance) && Objects.equals(created_at, account.created_at) && Objects.equals(updated_at, account.updated_at);
		}

		@Override
		public int hashCode() {
				return Objects.hash(id, name, type, status, balance, currency_code, created_at, updated_at);
		}
}
