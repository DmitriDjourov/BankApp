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
public class Manager {
		private final UUID id = UUID.randomUUID();
		private String first_name;
		private String last_name;
		private int status;
		private LocalDate created_at;
		private LocalDate updated_at;

		@Override
		public String toString() {
				return "Manager{" +
						       "id=" + id +
						       ", first_name='" + first_name + '\'' +
						       ", last_name='" + last_name + '\'' +
						       ", status=" + status +
						       ", created_at=" + created_at +
						       ", updated_at=" + updated_at +
						       '}';
		}

		@Override
		public boolean equals(Object o) {
				if (this == o) return true;
				if (o == null || getClass() != o.getClass()) return false;
				Manager manager = (Manager) o;
				return status == manager.status && Objects.equals(id, manager.id) && Objects.equals(first_name, manager.first_name) && Objects.equals(last_name, manager.last_name) && Objects.equals(created_at, manager.created_at) && Objects.equals(updated_at, manager.updated_at);
		}

		@Override
		public int hashCode() {
				return Objects.hash(id, first_name, last_name, status, created_at, updated_at);
		}
}