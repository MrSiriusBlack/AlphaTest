CREATE TABLE demo.provider
(
    id SERIAL NOT NULL CONSTRAINT pk_provider PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    balance NUMERIC NOT NULL DEFAULT 0
);

COMMENT ON TABLE demo.provider is 'Поставщики';
COMMENT ON COLUMN demo.provider.name IS 'Название поставщика';
COMMENT ON COLUMN demo.provider.balance IS 'Баланс поставщика';