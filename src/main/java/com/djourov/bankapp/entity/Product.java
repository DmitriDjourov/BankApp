package com.djourov.bankapp.entity;

import com.djourov.bankapp.entity.enums.AccountCurrencyCode;
import com.djourov.bankapp.entity.enums.ProductInterestRateStatus;
import com.djourov.bankapp.entity.enums.ProductTypeStatus;
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
@Table(name = "Product")

public class Product {
		@Id
		@GeneratedValue(strategy = GenerationType.UUID)
		@Column(name = "p_id")
		private UUID id;

		@Column(name = "p_name")
		private String name;

		@Enumerated(EnumType.ORDINAL)
		@Column(name = "p_status")
		private ProductTypeStatus status;

		@Enumerated(EnumType.ORDINAL)
		@Column(name = "p_currency_code")
		private AccountCurrencyCode currencyCode;

		@Enumerated(EnumType.ORDINAL)
		@Column(name = "p_interest_rate")
		private ProductInterestRateStatus interestRate;

		@Column(name = "p_limit_")
		private int limit;

		@Column(name = "p_create_at")
		private LocalDate createdAt;

		@Column(name = "p_update_at")
		private LocalDate updatedAt;

		@ManyToOne(fetch = FetchType.LAZY, cascade = {MERGE, PERSIST, REFRESH})
		@JoinColumn(name = "p_manager_id", referencedColumnName = "m_id")
		private Manager manager;

		@Override
		public boolean equals(Object o) {
				if (this == o) return true;
				if (o == null || getClass() != o.getClass()) return false;
				Product product = (Product) o;
				return Objects.equals(id, product.id) && Objects.equals(createdAt, product.createdAt) && Objects.equals(manager, product.manager);
		}

		@Override
		public int hashCode() {
				return Objects.hash(id, createdAt, manager);
		}

	@Override
	public String toString() {
		return "Product{" +
				       "id=" + id +
				       ", name='" + name + '\'' +
				       ", status=" + status +
				       ", currencyCode=" + currencyCode +
				       ", interestRate=" + interestRate +
				       ", limit=" + limit +
				       ", createdAt=" + createdAt +
				       ", updatedAt=" + updatedAt +
				       ", manager=" + manager +
				       '}';
	}
}
