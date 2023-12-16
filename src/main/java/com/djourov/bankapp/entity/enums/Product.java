package com.djourov.bankapp.entity.enums;

import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@AllArgsConstructor
public class Product {
		private final UUID id;
		private String name;
		private int status;
		private int currency_code;
		private double interest_rate;
		private int limit;
		private LocalDate created_at;
		private LocalDate updated_at;
		private Manager manager_id;

		@Override
		public boolean equals(Object o) {
				if (this == o) return true;
				if (o == null || getClass() != o.getClass()) return false;
				Product product = (Product) o;
				return Objects.equals(id, product.id);
		}

		@Override
		public int hashCode() {
				return Objects.hash(id);
		}

		@Override
		public String toString() {
				return "Product{" +
						       "id=" + id +
						       ", name='" + name + '\'' +
						       ", status=" + status +
						       ", currency_code=" + currency_code +
						       ", interest_rate=" + interest_rate +
						       ", limit=" + limit +
						       ", created_at=" + created_at +
						       ", updated_at=" + updated_at +
						       ", manager_id=" + manager_id +
						       '}';
		}
}
