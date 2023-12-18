package com.djourov.bankapp.entity.enums;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

import static jakarta.persistence.CascadeType.*;

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

		@ManyToOne(fetch = FetchType.LAZY, cascade = {MERGE, PERSIST, REFRESH})
		@JoinColumn(name = "p_manager_id", referencedColumnName = "m_id")
		private Manager manager;

		@Override
		public boolean equals(Object o) {
				if (this == o) return true;
				if (o == null || getClass() != o.getClass()) return false;
				Product product = (Product) o;
				return Objects.equals(id, product.id) && Objects.equals(created_at, product.created_at) && Objects.equals(manager, product.manager);
		}

		@Override
		public int hashCode() {
				return Objects.hash(id, created_at, manager);
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
						       ", manager=" + manager +
						       '}';
		}
}
