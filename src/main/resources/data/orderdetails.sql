DROP TABLE IF EXISTS orderdetails;

CREATE TABLE orderdetails
(
    orderdetails_id integer,
    order_id integer,
    product_id integer NOT NULL,
);

INSERT INTO orders VALUES (1, 2, 4369)
INSERT INTO orders VALUES (2, 4, 2679)
INSERT INTO orders VALUES (3, 1, 9088)
INSERT INTO orders VALUES (4, 1, 384)

