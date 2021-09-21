package me.vegura.transactionario.service.impl;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import me.vegura.transactionario.domain.dbmodel.Identity;
import me.vegura.transactionario.domain.dto.IdentityDto;
import me.vegura.transactionario.domain.mappers.IdentityMapper;
import me.vegura.transactionario.domain.service.IdentityDomainService;
import me.vegura.transactionario.exceptions.UnknownResourceException;
import me.vegura.transactionario.service.IdentityService;

@Service
@RequiredArgsConstructor
public class IdentityServiceImpl implements IdentityService {
	
	private final IdentityDomainService identityDomainService; 
	private final IdentityMapper identityMapper;
	
	@Override
	public IdentityDto findIdentity(UUID identityIdentifier) {
		final Optional<Identity> foundIdentityOptional = identityDomainService.findIdentityByIdentifier(identityIdentifier);		
		if (foundIdentityOptional.isEmpty())
			throw new UnknownResourceException();
		
		return foundIdentityOptional.map(id -> identityMapper.identityToIdentityDto(id)).get();
	}

	@Override
	public IdentityDto createIdentity(IdentityDto identityDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IdentityDto updateIdentity(IdentityDto identityDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteIdentity(IdentityDto identityDto) {
		// TODO Auto-generated method stub
		
	}
	
	
}
