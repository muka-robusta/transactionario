package me.vegura.transactionario.domain.service;

import me.vegura.transactionario.domain.dbmodel.Transaction;

public interface TransactionDomainService {
	Transaction createTransaction(Transaction transaction);
	Transaction processTransaction(Transaction transaction);
	Transaction undoTransaction(Transaction transaction);
}
