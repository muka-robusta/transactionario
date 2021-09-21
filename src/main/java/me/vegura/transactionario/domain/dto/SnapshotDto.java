package me.vegura.transactionario.domain.dto;

import java.time.LocalDateTime;
import java.util.Set;

import lombok.Data;
import lombok.experimental.Accessors;
import me.vegura.transactionario.domain.enums.SnapshotStatus;

@Data
@Accessors(chain = true)
public class SnapshotDto {
	private Long id;
	private SnapshotStatus snapshotStatus;
	
	private LocalDateTime snapshotTimeStart;
	private Integer balanceValueStart;
	
	private LocalDateTime snapshotTimeEnd;
	private Integer balanceValueEnd;
	
	private BalanceAccountDto balanceAccountDto;
	private Set<TransactionDto> transactions;
}
