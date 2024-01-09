package com.djourov.bankapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

import static jakarta.persistence.CascadeType.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "Transaction")

public class Transaction {
		@Id
		@GeneratedValue(strategy = GenerationType.UUID)
		@Column(name = "t_id")
		private UUID id;

		@Column(name = "t_type")
		private int type;

		@Column(name = "t_amount")
		private BigDecimal amount;

		@Column(name = "t_description")
		private String description;

		@Column(name = "t_create_at")
		private LocalDate createAt;

		@ManyToOne(fetch = FetchType.LAZY, cascade = {MERGE, PERSIST, REFRESH})
		@JoinColumn(name = "t_debit_account_id", referencedColumnName = "a_id")
		@JsonIgnore // без него не работает
		private Account debitAccountId;

		@ManyToOne(fetch = FetchType.LAZY, cascade = {MERGE, PERSIST, REFRESH})
		@JoinColumn(name = "t_credit_account_id", referencedColumnName = "a_id")
		@JsonIgnore // без него не работает
		private Account creditAccountId;

		@Override
		public boolean equals(Object o) {
				if (this == o) return true;
				if (o == null || getClass() != o.getClass()) return false;
				Transaction that = (Transaction) o;
				return Objects.equals(id, that.id) && Objects.equals(createAt, that.createAt) && Objects.equals(creditAccountId, that.creditAccountId);
		}

		@Override
		public int hashCode() {
				return Objects.hash(id, createAt, creditAccountId);
		}

	@Override
	public String toString() {
		return "Transaction{" +
				       "id=" + id +
				       ", type=" + type +
				       ", amount=" + amount +
				       ", description='" + description + '\'' +
				       ", createAt=" + createAt +
				       ", debitAccountId=" + debitAccountId +
				       ", creditAccountId=" + creditAccountId +
				       '}';
	}
}
