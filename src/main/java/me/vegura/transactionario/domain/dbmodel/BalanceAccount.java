package me.vegura.transactionario.domain.dbmodel;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.experimental.Accessors;
import me.vegura.transactionario.domain.enums.BalanceStatus;
import me.vegura.transactionario.domain.enums.BalanceType;

@Data
@Accessors(chain = true)
@Entity
@Table(name = "balance_accounts")
public class BalanceAccount {
	
	@Id
	@Column(name = "account_id")
	@org.hibernate.annotations.Type(type = "org.hibernate.type.PostgresUUIDType")
	private UUID balanceAccountIdentifier;
	
	@Enumerated(EnumType.STRING)
	private BalanceStatus balanceStatus;
	private LocalDateTime balanceCreationDate;
	private Integer balanceValue;
	
	@ManyToOne
	@JoinColumn(name = "identity_id")
	private Identity identity;
	
	@OneToMany(mappedBy = "balanceAccount", cascade = CascadeType.ALL)
	private Set<Snapshot> snapshots = new HashSet<>();
	
	@OneToOne(mappedBy = "balanceAccount", cascade = CascadeType.ALL)
	private Snapshot activeSnapshot;
	
	@Enumerated(EnumType.STRING)
	private BalanceType balanceType;
	
	public BalanceAccount addSnapshot(final Snapshot snapshot) {
		snapshots.add(snapshot);
		snapshot.setBalanceAccount(this);
		return this;
	}
}
