DROP TABLE IF EXISTS orderdetails;

CREATE TABLE orderdetails
(
    order_id integer,
    order_status character(20) NOT NULL,
    product_id integer NOT NULL,
    order_date date NOT NULL
);

INSERT INTO orders VALUES (1, 'submited', 4369, 2020-07-21)
INSERT INTO orders VALUES (2, 'submited', 2679, 2020-07-21)
INSERT INTO orders VALUES (3, 'submited', 9088, 2020-07-22)
INSERT INTO orders VALUES (4, 'submited', 384, 2020-07-23)

