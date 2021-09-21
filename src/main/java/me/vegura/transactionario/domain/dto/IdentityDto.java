package me.vegura.transactionario.domain.dto;

import java.util.Set;
import java.util.UUID;

import lombok.Data;
import lombok.experimental.Accessors;
import me.vegura.transactionario.domain.enums.IdentityRole;

@Data
@Accessors(chain = true)
public class IdentityDto {
	private UUID identityIdentifier;
	private ProfileDto profileDto;
	private String email;
	private Set<BalanceAccountDto> balanceAccounts;
	private IdentityRole identityRole;
}
