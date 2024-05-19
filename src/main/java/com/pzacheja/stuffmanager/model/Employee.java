package com.pzacheja.stuffmanager.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.proxy.HibernateProxy;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private Long id;
	private String name;
	private String surname;
	private String email;
	private String jobTitle;
	private String phone;
	private String imageUrl;
	private String employeeCode;

	public Employee(final String name, final String surname, final String email, final String jobTitle, final String phone, final String imageUrl) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.jobTitle = jobTitle;
		this.phone = phone;
		this.imageUrl = imageUrl;
		if (employeeCode.isBlank()) {
			this.employeeCode = UUID.randomUUID()
			                        .toString();
		}
	}

	@Override
	public final boolean equals(final Object o) {
		if (this == o) return true;
		if (o == null) return false;
		Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer()
		                                                                             .getPersistentClass() : o.getClass();
		Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer()
		                                                                                      .getPersistentClass() : this.getClass();
		if (thisEffectiveClass != oEffectiveClass) return false;
		final Employee employee = (Employee) o;
		return getId() != null && Objects.equals(getId(), employee.getId());
	}

	@Override
	public final int hashCode() {
		return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer()
		                                                               .getPersistentClass()
		                                                               .hashCode() : getClass().hashCode();
	}
}