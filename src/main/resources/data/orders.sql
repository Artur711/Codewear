DROP TABLE IF EXISTS orders;

CREATE TABLE orders
(
    id SERIAL PRIMARY KEY,
    order_id integer NOT NULL,
    user_id integer NOT NULL,
);

INSERT INTO orders VALUES (1, 1, 2)
INSERT INTO orders VALUES (2, 2, 3)
INSERT INTO orders VALUES (3, 3, 4)
INSERT INTO orders VALUES (4, 4, 1)
