package me.vegura.transactionario.service.impl;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import me.vegura.transactionario.domain.dto.BalanceAccountDto;
import me.vegura.transactionario.service.BalanceAccountService;

@Service
@RequiredArgsConstructor
public class BalanceAccountServiceImpl implements BalanceAccountService {
	
	
	
	@Override
	public BalanceAccountDto create(BalanceAccountDto accountDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BalanceAccountDto update(BalanceAccountDto accountDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<BalanceAccountDto> findAccountById(UUID accountId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAccount(UUID acountId) {
		// TODO Auto-generated method stub
		
	}

}
