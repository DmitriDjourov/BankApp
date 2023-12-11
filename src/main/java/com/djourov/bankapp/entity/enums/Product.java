package com.djourov.bankapp.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Builder
@AllArgsConstructor
@Data
public class Product {
		private final UUID id = UUID.randomUUID();
		private String name;
		private int status;
		private int currency_code;
		private double interest_rate;
		private int limit;
		private LocalDate created_at;
		private LocalDate updated_at;
		private Manager manager_id;

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

		@Override
		public boolean equals(Object o) {
				if (this == o) return true;
				if (o == null || getClass() != o.getClass()) return false;
				Product product = (Product) o;
				return status == product.status && currency_code == product.currency_code && limit == product.limit && Objects.equals(id, product.id) && Objects.equals(name, product.name) && Objects.equals(interest_rate, product.interest_rate) && Objects.equals(created_at, product.created_at) && Objects.equals(updated_at, product.updated_at);
		}

		@Override
		public int hashCode() {
				return Objects.hash(id, name, status, currency_code, interest_rate, limit, created_at, updated_at);
		}
}
