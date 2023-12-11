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
public class Agreement {
		private final UUID id = UUID.randomUUID();
		private double interest_rate;
		private int status;
		private BigDecimal sum;
		private LocalDate created_at;
		private LocalDate updated_at;
		private Product product_id;
		private Account account_id;

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

		@Override
		public boolean equals(Object o) {
				if (this == o) return true;
				if (o == null || getClass() != o.getClass()) return false;
				Agreement agreement = (Agreement) o;
				return status == agreement.status && Objects.equals(id, agreement.id) && Objects.equals(interest_rate, agreement.interest_rate) && Objects.equals(sum, agreement.sum) && Objects.equals(created_at, agreement.created_at) && Objects.equals(updated_at, agreement.updated_at);
		}

		@Override
		public int hashCode() {
				return Objects.hash(id, interest_rate, status, sum, created_at, updated_at);
		}
}
