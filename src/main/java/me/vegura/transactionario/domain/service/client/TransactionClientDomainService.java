package me.vegura.transactionario.domain.service.client;

import me.vegura.transactionario.domain.dbmodel.Transaction;

public interface TransactionClientDomainService {
	Transaction processTransaction(Transaction transaction);
}
