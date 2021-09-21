package me.vegura.transactionario.service;

import java.util.UUID;

import me.vegura.transactionario.domain.dto.IdentityDto;

public interface IdentityService {
	IdentityDto findIdentity(UUID identityIdentifier);
	IdentityDto createIdentity(IdentityDto identityDto);
	IdentityDto updateIdentity(IdentityDto identityDto);
	void deleteIdentity(IdentityDto identityDto);
}
