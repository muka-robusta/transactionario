package me.vegura.transactionario.domain.dbmodel;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.experimental.Accessors;
import me.vegura.transactionario.domain.enums.SnapshotStatus;

@Data
@Accessors(chain = true)
@Entity
@Table(name = "snapshots")
public class Snapshot {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "snapshot_id")
	private Long snapshotIdentifier;
	
	@Enumerated(EnumType.STRING)
	private SnapshotStatus snapshotStatus;
	
	private LocalDateTime snapshotTimeStart;
	private Integer snapshotBalanceValueStart;
	
	private LocalDateTime snapshotTimeEnd;
	private Integer snapshotBalanceValueEnd;
	
	@ManyToOne
	@JoinColumn(name = "account_id")
	private BalanceAccount balanceAccount;
	
	@OneToMany
	private Set<Transaction> transactions;
}
