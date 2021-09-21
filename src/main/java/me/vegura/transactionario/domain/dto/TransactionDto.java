package me.vegura.transactionario.domain.dto;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.experimental.Accessors;
import me.vegura.transactionario.domain.enums.TransactionOperationEnumeration;

@Data
@Accessors(chain = true)
public class TransactionDto {
	private Long id;
	private TransactionOperationEnumeration transactionDefifnition;
	private Integer transactionValue;
	private LocalDateTime transactionTime;
	private BalanceAccountDto senderAccount;
	private BalanceAccountDto receiverAccount;
}
