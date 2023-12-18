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
@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "client")

public class Client {
		@Id
		@GeneratedValue(strategy = GenerationType.UUID)
		@Column(name = "c_id")
		private UUID id;

		@Column(name = "c_status")
		private int status;

		@Column(name = "c_tax_code")
		private String tax_code;

		@Column(name = "first_name")
		private String first_name;

		@Column(name = "last_name")
		private String last_name;

		@Column(name = "c_email")
		private String email;

		@Column(name = "c_address")
		private String address;

		@Column(name = "c_phone")
		private String phone;

		@Column(name = "created_at")
		private LocalDate created_at;

		@Column(name = "updated_at")
		private LocalDate updated_at;

		private Manager manager;

		@Override
		public boolean equals(Object o) {
				if (this == o) return true;
				if (o == null || getClass() != o.getClass()) return false;
				Client client = (Client) o;
				return Objects.equals(id, client.id) && Objects.equals(manager, client.manager);
		}

		@Override
		public int hashCode() {
				return Objects.hash(id, manager);
		}

		@Override
		public String toString() {
				return "Client{" +
						       "id=" + id +
						       ", status=" + status +
						       ", tax_code='" + tax_code + '\'' +
						       ", first_name='" + first_name + '\'' +
						       ", last_name='" + last_name + '\'' +
						       ", email='" + email + '\'' +
						       ", address='" + address + '\'' +
						       ", phone='" + phone + '\'' +
						       ", created_at=" + created_at +
						       ", updated_at=" + updated_at +
						       ", manager=" + manager +
						       '}';
		}
}
