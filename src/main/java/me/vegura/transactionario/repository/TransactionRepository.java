package me.vegura.transactionario.repository;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import me.vegura.transactionario.domain.dbmodel.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{
	@Query(value = "SELECT * FROM transactions "
			+ "    LEFT JOIN balance_accounts receiver_account on transactions.receiver_account = receiver_account.account_id "
			+ "    LEFT JOIN balance_accounts sender_account on transactions.sender_account = sender_account.account_id "
			+ "    WHERE (receiver_account.account_id = :accountId OR sender_account.account_id = :accountId) "
			+ "         AND transactions.transaction_time > :startDate AND transactions.transaction_time < :endDate ",
			nativeQuery = true
	)
	Page<Transaction> findTransactionsRelateToAccountBetweenTimePeriod(
			@Param("accountId") UUID accountId, 
			@Param("startDate") String startDateString,
			@Param("endDate") String endDateString,
			Pageable pageable
	);
	
}
