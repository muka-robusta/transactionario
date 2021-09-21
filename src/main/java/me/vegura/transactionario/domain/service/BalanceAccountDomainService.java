package me.vegura.transactionario.domain.service;

import java.util.UUID;

import me.vegura.transactionario.domain.dbmodel.BalanceAccount;
import me.vegura.transactionario.domain.dbmodel.Identity;

public interface BalanceAccountDomainService {
	BalanceAccount createEmptyBalanceAccountByIdentity(Identity identity);
	BalanceAccount createBalanceBudgetByIdentity(Identity identity, Integer startingValue);
	BalanceAccount updateBalanceAccount(BalanceAccount balanceAccount);
	BalanceAccount deactivateAccount(BalanceAccount balanceAccount);
	BalanceAccount findBalanceAccount(UUID id);
	void reopenAllSnapshots();
	void reopenSnapshotOnAccount(BalanceAccount balanceAccount);
}
