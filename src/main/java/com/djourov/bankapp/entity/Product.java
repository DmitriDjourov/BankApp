package com.djourov.bankapp.entity;

import com.djourov.bankapp.entity.enums.AccountCurrencyCode;
import com.djourov.bankapp.entity.enums.ProductName;
import com.djourov.bankapp.entity.enums.ProductStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "Product")

public class Product {
		@Id
		@UuidGenerator
		@Column(name = "p_id")
		private UUID id;

	  @Enumerated(EnumType.STRING)
		@Column(name = "p_name")
		private ProductName name;

		@Enumerated(EnumType.ORDINAL)
		@Column(name = "p_status")
		private ProductStatus status;

		@Enumerated(EnumType.ORDINAL)
		@Column(name = "p_currency_code")
		private AccountCurrencyCode currencyCode;

		@Column(name = "p_interest_rate")
		private BigDecimal interestRate;

		@Column(name = "p_limit_")
		private int limit;

		@Column(name = "p_create_at")
		private LocalDate createdAt;

		@Column(name = "p_update_at")
		private LocalDate updatedAt;

		@ManyToOne()
		@JsonIgnore
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
