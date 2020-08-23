CREATE TABLE demo.client
(
    id SERIAL NOT NULL CONSTRAINT pk_client PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    balance NUMERIC NOT NULL DEFAULT 0
);

COMMENT ON TABLE demo.client is 'Клиенты';
COMMENT ON COLUMN demo.client.name IS 'Название клиента';
COMMENT ON COLUMN demo.client.balance IS 'Баланс клиента';