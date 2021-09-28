package me.vegura.transactionario.domain.service.client.impl;

import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import me.vegura.transactionario.domain.dbmodel.BalanceAccount;
import me.vegura.transactionario.domain.dbmodel.Identity;
import me.vegura.transactionario.domain.service.client.BalanceAccountClientDomainService;
import me.vegura.transactionario.repository.BalanceAccountRepository;

@Service
@RequiredArgsConstructor
public class BalanceAccountClientDomainServiceImpl implements BalanceAccountClientDomainService {
	
	private final BalanceAccountRepository balanceAccountRepository;
	
	@Override
	public Set<BalanceAccount> findActiveAccountBalances(Identity identity) {
		
		final Set<BalanceAccount> balanceAccountsById = new HashSet<>();
		
		balanceAccountRepository.findBalanceAccountByIdentity(identity.getIdentityIdentifier())
		.spliterator()
		.forEachRemaining(account -> balanceAccountsById.add(account));
		
		return balanceAccountsById;
	}

	
}
