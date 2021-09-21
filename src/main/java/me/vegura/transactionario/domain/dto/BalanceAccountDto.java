package me.vegura.transactionario.domain.dto;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import lombok.Data;
import lombok.experimental.Accessors;
import me.vegura.transactionario.domain.enums.BalanceStatus;
import me.vegura.transactionario.domain.enums.BalanceType;

@Data
@Accessors(chain = true)
public class BalanceAccountDto {
	private UUID accountIdentifier;
	private BalanceStatus balanceStatus;
	private Integer balanceValue;
	private LocalDateTime balanceCreationDate;
	private IdentityDto identityDto;
	private SnapshotDto activeSnapshot;
	private Set<SnapshotDto> snapshots;
	private BalanceType balanceType;
}
