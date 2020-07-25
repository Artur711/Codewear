DROP TABLE IF EXISTS orders;

CREATE TABLE orders
(
    id SERIAL PRIMARY KEY,
    order_id integer NOT NULL,
    user_id integer NOT NULL,
    order_date date NOT NULL,
    order_status character(20) NOT NULL,
    payment_status character(20) NOT NULL

);

INSERT INTO orders VALUES (1, 1, 2, '2020-07-21','shipped', 'paid');
INSERT INTO orders VALUES (2, 2, 3, '2020-07-22', 'submited', 'paid');
INSERT INTO orders VALUES (3, 3, 4, '2020-07-22', 'submited', 'paid');
INSERT INTO orders VALUES (4, 4, 1, '2020-07-23', 'submited', 'paid');
