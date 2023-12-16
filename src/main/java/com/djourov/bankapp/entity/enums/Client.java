package com.djourov.bankapp.entity.enums;

import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@AllArgsConstructor
public class Client {
		private final UUID id;
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
		public boolean equals(Object o) {
				if (this == o) return true;
				if (o == null || getClass() != o.getClass()) return false;
				Client client = (Client) o;
				return Objects.equals(id, client.id);
		}
		@Override
		public int hashCode() {
				return Objects.hash(id);
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
