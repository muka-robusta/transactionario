CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
CREATE TABLE IF NOT EXISTS profiles (
	profile_id UUID NOT NULL PRIMARY KEY DEFAULT uuid_generate_v4(),
	first_name varchar(64) NOT NULL,
	last_name varchar(64) NOT NULL, 
	birth_date date,
	description text,
	creation_datetime timestamp WITH time ZONE
);

CREATE TABLE IF NOT EXISTS identities (
	identity_id UUID NOT NULL PRIMARY KEY DEFAULT uuid_generate_v4(),
	profile_id UUID NOT NULL,
	email varchar(256) UNIQUE,
	identity_role varchar(16) NOT NULL,
	CONSTRAINT fk_profile
		FOREIGN KEY(profile_id)
		REFERENCES profiles(profile_id)
);

CREATE TABLE IF NOT EXISTS balance_accounts (
	account_id UUID NOT NULL PRIMARY KEY DEFAULT uuid_generate_v4(),
	identity_id UUID NOT NULL,
	balance_status varchar(8) NOT NULL,
	balance_creation_date timestamp WITH time ZONE,
	balance_value int,
	account_type varchar(16) NOT NULL,
	CONSTRAINT fk_identity 
		FOREIGN KEY (identity_id)
		REFERENCES identities(identity_id)
);

CREATE SEQUENCE snapshot_id_seq;
CREATE TABLE IF NOT EXISTS snapshots (
	snapshot_id int NOT NULL PRIMARY KEY DEFAULT nextval('snapshot_id_seq'),
	snapshot_status varchar(16) NOT NULL,
	snapshot_time_start timestamp WITH time ZONE NOT null,
	snapshot_balance_value_start int NOT NULL,
	snapshot_time_end timestamp WITH time ZONE,
	snapshot_balance_value_end int,
	balance_account_id UUID NOT NULL, 
	CONSTRAINT fk_balance_account 
		FOREIGN KEY (balance_account_id)
		REFERENCES balance_accounts(account_id)
);

CREATE SEQUENCE transaction_id_seq;
CREATE TABLE IF NOT EXISTS transactions(
	transaction_id int NOT NULL PRIMARY KEY DEFAULT nextval('transaction_id_seq'),
	transaction_operation_type varchar(16) NOT NULL,
	transaction_value int NOT NULL,
	transaction_time timestamp WITH time ZONE NOT NULL,
	sender_account UUID NOT NULL,
	receiver_account UUID NOT NULL,
	transaction_processor UUID NOT NULL,
	CONSTRAINT fk_sender_account 
		FOREIGN KEY (sender_account)
		REFERENCES balance_accounts(account_id),
	CONSTRAINT fk_receiver_account
		FOREIGN KEY (receiver_account)
		REFERENCES balance_accounts(account_id),
	CONSTRAINT fk_transaction_processor
		FOREIGN KEY (transaction_processor)
		REFERENCES identities(identity_id)
);

ALTER TABLE balance_accounts ADD COLUMN active_snapshot_id int; 
ALTER TABLE  balance_accounts ADD 
	CONSTRAINT fk_active_snapshot
		FOREIGN KEY (active_snapshot_id)
		REFERENCES snapshots(snapshot_id); 