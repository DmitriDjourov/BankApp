package com.djourov.bankapp.entity.enums;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@AllArgsConstructor
public class Agreement {
		private final UUID id;
		private double interest_rate;
		private int status;
		private BigDecimal sum;
		private LocalDate created_at;
		private LocalDate updated_at;
		private Product product_id;
		private Account account_id;

		@Override
		public boolean equals(Object o) {
				if (this == o) return true;
				if (o == null || getClass() != o.getClass()) return false;
				Agreement agreement = (Agreement) o;
				return Objects.equals(id, agreement.id);
		}

		@Override
		public int hashCode() {
				return Objects.hash(id);
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
