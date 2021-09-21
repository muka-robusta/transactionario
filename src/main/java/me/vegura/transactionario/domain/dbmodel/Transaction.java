package me.vegura.transactionario.domain.dbmodel;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.experimental.Accessors;
import me.vegura.transactionario.domain.enums.TransactionOperationEnumeration;

@Data
@Accessors(chain = true)
@Entity
@Table(name = "transactions")
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "transaction_id")
	private Long transactionIdentifier;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "transaction_operation_type", nullable = false)
	private TransactionOperationEnumeration transactionDefinition;
	
	private Integer transactionValue;
	
	private LocalDateTime transactionTime;
	
	@ManyToOne
	@JoinColumn(name = "sender_account")
	private BalanceAccount senderAccount;
	
	@ManyToOne
	@JoinColumn(name = "receiver_account")
	private BalanceAccount receiverAccount;
	
	@ManyToOne
	@JoinColumn(name = "transaction_processor")
	private Identity transactionProcessor;
	
}
