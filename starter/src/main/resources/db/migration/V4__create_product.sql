CREATE TABLE demo.product
(
    name VARCHAR(255) NOT NULL CONSTRAINT pk_product PRIMARY KEY,
    provider_id INT NOT NULL,

    CONSTRAINT fk_provider_id FOREIGN KEY (provider_id) REFERENCES demo.provider(id)
);

COMMENT ON TABLE demo.product is 'Продукты/услуги';
COMMENT ON COLUMN demo.product.name IS 'Название продукта/услуга';
COMMENT ON COLUMN demo.product.provider_id IS 'ID поставщика продукта/услуги';