package com.djourov.bankapp.entity.enums;

import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;
@AllArgsConstructor
public class Manager {
		private final UUID id;
		private String first_name;
		private String last_name;
		private int status;
		private LocalDate created_at;
		private LocalDate updated_at;

		@Override
		public boolean equals(Object o) {
				if (this == o) return true;
				if (o == null || getClass() != o.getClass()) return false;
				Manager manager = (Manager) o;
				return Objects.equals(id, manager.id);
		}

		@Override
		public int hashCode() {
				return Objects.hash(id);
		}

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
}