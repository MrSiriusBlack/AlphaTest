CREATE TABLE demo.active_product
(
    id SERIAL NOT NULL CONSTRAINT pk_active_product PRIMARY KEY,
    product VARCHAR (255) NOT NULL,
    client_id INT NOT NULL,
    cost NUMERIC NOT NULL,
    is_active BOOL NOT NULL,

    CONSTRAINT fk_product FOREIGN KEY (product) REFERENCES demo.product(name),
    CONSTRAINT fk_client_id FOREIGN KEY (client_id) REFERENCES demo.client(id)
);

COMMENT ON TABLE demo.active_product is 'Активные услуги';
COMMENT ON COLUMN demo.active_product.product IS 'Название продукта';
COMMENT ON COLUMN demo.active_product.client_id IS 'ID покупателя';
COMMENT ON COLUMN demo.active_product.cost IS 'Стоимость';
COMMENT ON COLUMN demo.active_product.is_active IS 'Активность услуги';