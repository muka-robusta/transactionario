package me.vegura.transactionario.domain.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ProfileDto {
	private UUID profileIdentifier;
	private String firstName;
	private String lastName;
	private LocalDate birthDate;
	private String description;
//	private Byte[] image;
	private LocalDateTime creationDateTime;
}
