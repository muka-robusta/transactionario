package me.vegura.transactionario.domain.service;

import java.util.Optional;
import java.util.UUID;

import me.vegura.transactionario.domain.dbmodel.Identity;

public interface IdentityDomainService {
	Optional<Identity> findIdentityByIdentifier(UUID id);
	Identity identityProvisioning(Identity identity);
	Identity updateIdentity(Identity identity);
	void identityDeprovisioning(Identity identity);
}
