package me.vegura.transactionario.domain.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import me.vegura.transactionario.domain.dbmodel.BalanceAccount;
import me.vegura.transactionario.domain.dbmodel.Identity;
import me.vegura.transactionario.domain.dbmodel.Snapshot;
import me.vegura.transactionario.domain.enums.BalanceStatus;
import me.vegura.transactionario.domain.enums.BalanceType;
import me.vegura.transactionario.domain.enums.SnapshotStatus;
import me.vegura.transactionario.domain.service.BalanceAccountDomainService;
import me.vegura.transactionario.exceptions.UnknownResourceException;
import me.vegura.transactionario.repository.BalanceAccountRepository;
import me.vegura.transactionario.repository.SnapshotRepository;

@Service
@RequiredArgsConstructor
public class BalanceAccountDomainServiceImpl implements BalanceAccountDomainService {

	private final BalanceAccountRepository balanceAccountRepository;
	private final SnapshotRepository snapshotRepository;
	
	@Override
	public BalanceAccount createEmptyBalanceAccountByIdentity(Identity identity) {
		final BalanceAccount emptyAccount = createEmptyAccount(identity, 0);
		emptyAccount.setBalanceType(BalanceType.PERSONAL);
		return balanceAccountRepository.save(emptyAccount);
	}

	@Override
	public BalanceAccount createBalanceBudgetByIdentity(Identity identity, Integer startingValue) {
		final BalanceAccount emptyBudgetAccount = createEmptyAccount(identity, startingValue);
		emptyBudgetAccount.setBalanceType(BalanceType.BUDGET);
		return balanceAccountRepository.save(emptyBudgetAccount);
	}

	@Override
	public BalanceAccount updateBalanceAccount(BalanceAccount balanceAccount) {
		
		return null;
	}

	@Transactional
	@Override
	public BalanceAccount deactivateAccount(BalanceAccount balanceAccount) {
		final Optional<Snapshot> activeSnapshotOptional = snapshotRepository.findById(
				balanceAccount.getActiveSnapshot().getSnapshotIdentifier());
		
		if (activeSnapshotOptional.isEmpty())
			throw new UnknownResourceException();
		
		final Snapshot activeSnapshot = activeSnapshotOptional.get();

		
		return null;
	}

	@Override
	public BalanceAccount findBalanceAccount(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void reopenAllSnapshots() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reopenSnapshotOnAccount(BalanceAccount balanceAccount) {
		// TODO Auto-generated method stub
		
	}
	
	// Private
	
	private static BalanceAccount createEmptyAccount(Identity identity, int initialValue) {
		
		final Snapshot snapshot = new Snapshot()
				.setSnapshotStatus(SnapshotStatus.ACTIVE)
				.setSnapshotTimeStart(LocalDateTime.now());
		
		final BalanceAccount balanceAccount = new BalanceAccount()
				.setBalanceStatus(BalanceStatus.ACTIVE)
				.setActiveSnapshot(snapshot)
				.addSnapshot(snapshot)
				.setIdentity(identity)
				.setBalanceValue(initialValue)
				.setBalanceCreationDate(LocalDateTime.now());
		
		return balanceAccount;
		
	}

	
}
