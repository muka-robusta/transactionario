CREATE PROCEDURE process_transaction(sender uuid, receiver uuid, amount integer)
LANGUAGE SQL
AS $$

	UPDATE balance_account 
		SET balance_value = balance_value - amount
		WHERE account_id = sender;
	UPDATE balance_account
		SET balance_value = balance_value + amount
		WHERE account_id = receiver;

$$;

CREATE TRIGGER balance_account_changer 
	AFTER INSERT ON transactions
	FOR EACH ROW 
	EXECUTE PROCEDURE process_transaction(sender_account, receiver_account, transaction_value);