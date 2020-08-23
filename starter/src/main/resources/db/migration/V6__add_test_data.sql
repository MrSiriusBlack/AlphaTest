INSERT INTO demo.provider VALUES (1, 'Поставщик ТВ', 5000);
INSERT INTO demo.provider VALUES (2, 'Поставщик Интернет', 7500);

INSERT INTO demo.product VALUES ('ТВ', 1);
INSERT INTO demo.product VALUES ('Интернет', 2);

INSERT INTO demo.client VALUES (1, 'Иван Петров', 1000);
INSERT INTO demo.client VALUES (2, 'Петр Иванов', 500);
INSERT INTO demo.client VALUES (3, 'Пафнутий Сидоров', 1400);

INSERT INTO demo.active_product VALUES (1, 'ТВ', 1, 300, true);
INSERT INTO demo.active_product VALUES (2, 'Интернет', 1, 250, true);
INSERT INTO demo.active_product VALUES (3, 'Интернет', 3, 270, true);
INSERT INTO demo.active_product VALUES (4, 'ТВ', 2, 340, true);

ALTER SEQUENCE demo.client_id_seq START 4;
ALTER SEQUENCE demo.provider_id_seq START 3;
ALTER SEQUENCE demo.active_product_id_seq START 5;