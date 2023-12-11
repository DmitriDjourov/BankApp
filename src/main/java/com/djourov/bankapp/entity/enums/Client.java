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
public class Client {
		private final UUID id = UUID.randomUUID();
		private int status;
		private String tax_code;
		private String first_name;
		private String last_name;
		private String email;
		private String address;
		private String phone;
		private LocalDate created_at;
		private LocalDate updated_at;
		private Manager manager;

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

		@Override
		public boolean equals(Object o) {
				if (this == o) return true;
				if (o == null || getClass() != o.getClass()) return false;
				Client client = (Client) o;
				return status == client.status && Objects.equals(id, client.id) && Objects.equals(tax_code, client.tax_code) && Objects.equals(first_name, client.first_name) && Objects.equals(last_name, client.last_name) && Objects.equals(email, client.email) && Objects.equals(address, client.address) && Objects.equals(phone, client.phone) && Objects.equals(created_at, client.created_at) && Objects.equals(updated_at, client.updated_at);
		}

		@Override
		public int hashCode() {
				return Objects.hash(id, status, tax_code, first_name, last_name, email, address, phone, created_at, updated_at);
		}
}
