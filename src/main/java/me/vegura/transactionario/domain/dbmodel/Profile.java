package me.vegura.transactionario.domain.dbmodel;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@Entity
@Table(name = "profiles")
public class Profile {
	
	@Id
	@Column(name = "profile_id")
	@org.hibernate.annotations.Type(type = "org.hibernate.type.PostgresUUIDType")
	private UUID profileIdentifier;
	
	@Column(name = "first_name", nullable = false)
	private String firstName;
	
	@Column(name = "last_name", nullable = false)
	private String lastName;
	private LocalDate birthDate;
	private String description;
	
//	@Lob
//	private Byte[] photo;
	
	@Column(name = "creation_datetime", nullable = false)
	private LocalDateTime creationDateTime;
	
}
