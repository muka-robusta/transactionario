package me.vegura.transactionario.domain.service.client.impl;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import me.vegura.transactionario.domain.dbmodel.BalanceAccount;
import me.vegura.transactionario.domain.dbmodel.Snapshot;
import me.vegura.transactionario.domain.dbmodel.Transaction;
import me.vegura.transactionario.domain.service.client.SnapshotClientDomainService;
import me.vegura.transactionario.repository.SnapshotRepository;
import me.vegura.transactionario.repository.TransactionRepository;

@Service
@RequiredArgsConstructor
public class SnapshotClientDomainServiceImpl implements SnapshotClientDomainService {

	// Constants
	
	private static final Integer NUMBER_OF_TRANSACTIONS_ON_PAGE = 7;
	
	// Variables
	
	private final SnapshotRepository snapshotRepository;
	private final TransactionRepository transactionRepository;
	
	// Public
	
	@Override
	public Optional<Snapshot> findLastBy(BalanceAccount balanceAccount) {
		final Snapshot activeSnapshot = balanceAccount.getActiveSnapshot();
		
		if (activeSnapshot == null)
			return Optional.empty();
		
		final Page<Transaction> lastTransactions = fetchPage(balanceAccount, 
				activeSnapshot.getSnapshotTimeStart(), 
				LocalDateTime.now(), 
				0);
		
		activeSnapshot.setTransactions(lastTransactions.toSet());
		
		return Optional.of(activeSnapshot);
	}
	
	@Override
	public Optional<Snapshot> findBy(Long id) {
		return snapshotRepository.findById(null);
	}
	
	@Override
	public Optional<Snapshot> findLastBy(BalanceAccount balanceAccount, int pageNumber) {
		final Snapshot activeSnapshot = balanceAccount.getActiveSnapshot();
		if (activeSnapshot == null)
			return Optional.empty();
		
		final Page<Transaction> fetchedPage = fetchPage(balanceAccount, 
				activeSnapshot.getSnapshotTimeStart(), 
				LocalDateTime.now(), 
				pageNumber);
		
		final Set<Transaction> transactions = activeSnapshot.getTransactions();
		if (transactions != null && transactions.size() != 0)
			fetchedPage.forEach(transactions::add);
		else 
			activeSnapshot.setTransactions(fetchedPage.toSet());
			
		return Optional.of(activeSnapshot);
	}
	
	// Private 
	
	private Page<Transaction> fetchPage(BalanceAccount balanceAccount, 
			LocalDateTime dateStart, 
			LocalDateTime dateEnd, 
			int pageNumber) {
		
		return transactionRepository.findTransactionsRelateToAccountBetweenTimePeriod(
				balanceAccount.getBalanceAccountIdentifier(),
				generateDateTimeString(dateStart),
				generateDateTimeString(dateEnd),
				generatePageRequest(pageNumber));
	}
	
	private static String generateDateTimeString(LocalDateTime dateTime) {
		final StringBuilder dateStringBuilder = new StringBuilder();
		dateStringBuilder.append(dateTime.getYear())
			.append("-")
			.append(dateTime.getMonthValue())
			.append("-")
			.append(dateTime.getDayOfMonth())
			.append(" ")
			.append(dateTime.getHour())
			.append(":")
			.append(dateTime.getMinute())
			.append(":")
			.append(dateTime.getSecond())
			.append(".000000 +00:00");
			
		return dateStringBuilder.toString();
	}
	
	private static PageRequest generatePageRequest(int pageOrderNumber) {
		return PageRequest.of(pageOrderNumber, NUMBER_OF_TRANSACTIONS_ON_PAGE);
	}

}
