package me.vegura.transactionario.domain.service.client.impl;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import me.vegura.transactionario.domain.dbmodel.Transaction;
import me.vegura.transactionario.domain.service.client.TransactionClientDomainService;
import me.vegura.transactionario.repository.BalanceAccountRepository;
import me.vegura.transactionario.repository.TransactionRepository;

@Service
@RequiredArgsConstructor
public class TransactionClientDomainServiceImpl implements TransactionClientDomainService {

	private final TransactionRepository transactionRepository;
	private final BalanceAccountRepository balanceAccountRepository;
	
	@Override
	public Transaction processTransaction(Transaction transaction) {
		// perform changing state of the balance account and registering transaction
		
	}

}
