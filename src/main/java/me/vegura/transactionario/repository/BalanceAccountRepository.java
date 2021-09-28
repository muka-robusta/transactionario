package me.vegura.transactionario.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import me.vegura.transactionario.domain.dbmodel.BalanceAccount;

public interface BalanceAccountRepository extends JpaRepository<BalanceAccount, UUID> {
	@Query(value = "SELECT account "
			+ "FROM BalanceAccount account "
			+ "JOIN account.identity identity "
			+ "WHERE identity.identityIdentifier = :identityId"
	)
	Iterable<BalanceAccount> findBalanceAccountByIdentity(@Param("identityId") UUID identityId);
}
