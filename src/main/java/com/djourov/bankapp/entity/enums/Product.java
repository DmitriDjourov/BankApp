package com.djourov.bankapp.entity.enums;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "product")

public class Product {
		@Id
		@GeneratedValue(strategy = GenerationType.UUID)
		@Column(name = "p_id")
		private UUID id;

		@Column(name = "p_name")
		private String name;

		@Column(name = "p_status")
		private int status;

		@Column(name = "p_currency_code")
		private int currency_code;

		@Column(name = "p_interest_rate")
		private double interest_rate;

		@Column(name = "p_limit")
		private int limit;

		@Column(name = "p_created_at")
		private LocalDate created_at;

		@Column(name = "p_updated_at")
		private LocalDate updated_at;

		private Manager manager_id;

		@Override
		public boolean equals(Object o) {
				if (this == o) return true;
				if (o == null || getClass() != o.getClass()) return false;
				Product product = (Product) o;
				return Objects.equals(id, product.id) && Objects.equals(created_at, product.created_at) && Objects.equals(manager_id, product.manager_id);
		}

		@Override
		public int hashCode() {
				return Objects.hash(id, created_at, manager_id);
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
