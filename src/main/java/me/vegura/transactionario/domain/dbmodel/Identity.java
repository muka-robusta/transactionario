package me.vegura.transactionario.domain.dbmodel;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.experimental.Accessors;
import me.vegura.transactionario.domain.enums.IdentityRole;

@Data
@Accessors(chain = true)
@Entity
@Table(name = "identities")
public class Identity {
	
	@Id
	@Column(name = "identity_id")
	@org.hibernate.annotations.Type(type = "org.hibernate.type.PostgresUUIDType")
	private UUID identityIdentifier;

	private String email;
	
	@OneToOne
	private Profile profile;
	
	@OneToMany(mappedBy = "identity")
	private Set<BalanceAccount> balances = new HashSet<>();
	
	@Enumerated(value = EnumType.STRING)
	@Column(name = "identity_role")
	private IdentityRole identityRole;
}
