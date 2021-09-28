package me.vegura.transactionario.domain.service.client;

import java.util.Set;
import me.vegura.transactionario.domain.dbmodel.BalanceAccount;
import me.vegura.transactionario.domain.dbmodel.Identity;

public interface BalanceAccountClientDomainService {
	Set<BalanceAccount> findActiveAccountBalances(Identity identity);
}
