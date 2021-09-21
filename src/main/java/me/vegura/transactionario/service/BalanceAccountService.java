package me.vegura.transactionario.service;

import java.util.Optional;
import java.util.UUID;

import me.vegura.transactionario.domain.dto.BalanceAccountDto;

public interface BalanceAccountService {
	BalanceAccountDto create(BalanceAccountDto accountDto);
	BalanceAccountDto update(BalanceAccountDto accountDto);
	Optional<BalanceAccountDto> findAccountById(UUID accountId);
	void deleteAccount(UUID acountId);
}
