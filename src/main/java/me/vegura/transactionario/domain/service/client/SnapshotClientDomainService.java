package me.vegura.transactionario.domain.service.client;

import java.util.Optional;
import me.vegura.transactionario.domain.dbmodel.BalanceAccount;
import me.vegura.transactionario.domain.dbmodel.Snapshot;

public interface SnapshotClientDomainService {
	Optional<Snapshot> findLastBy(BalanceAccount balanceAccount);
	Optional<Snapshot> findLastBy(BalanceAccount balanceAccount, int pageNum);
	Optional<Snapshot> findBy(Long id);
}
