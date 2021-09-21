package me.vegura.transactionario.domain.service.impl;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import me.vegura.transactionario.domain.dbmodel.Identity;
import me.vegura.transactionario.domain.enums.IdentityRole;
import me.vegura.transactionario.domain.service.IdentityDomainService;
import me.vegura.transactionario.exceptions.UnknownResourceException;
import me.vegura.transactionario.repository.IdentityRepository;

@Service
@RequiredArgsConstructor
public class IdentityDomainServiceImpl implements IdentityDomainService {

	private final IdentityRepository identityRepository;
	
	@Override
	public Optional<Identity> findIdentityByIdentifier(UUID id) {
		final Optional<Identity> foundIdentity = identityRepository.findById(id);
		if (foundIdentity.isEmpty() || 
				foundIdentity.get().getIdentityRole().equals(IdentityRole.DEACTIVATED))
			throw new UnknownResourceException();
		
		return foundIdentity;
	}
	
	@Override
	public Identity identityProvisioning(Identity identity) {
		identity.setIdentityRole(IdentityRole.NONE);
		return identityRepository.save(identity);
	}

	@Override
	public Identity updateIdentity(Identity identity) {
		final UUID identityIdentifier = identity.getIdentityIdentifier();
		if (identityRepository.findById(identityIdentifier).isEmpty())
			throw new UnknownResourceException();
		
		return identityRepository.save(identity);
	}

	@Override
	public void identityDeprovisioning(Identity identity) {
		identity.setIdentityRole(IdentityRole.DEACTIVATED);
	}


}
