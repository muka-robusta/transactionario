package me.vegura.transactionario.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import me.vegura.transactionario.domain.dbmodel.BalanceAccount;

public interface BalanceAccountRepository extends JpaRepository<BalanceAccount, UUID> {

}
