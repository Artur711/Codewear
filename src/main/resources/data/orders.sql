DROP TABLE IF EXISTS orders;

CREATE TABLE orders
(
    sales_order_id integer NOT NULL,
    order_date date NOT NULL,
    due_date date NOT NULL,
    status character(20) NOT NULL,
    sales_order_number character(10) NOT NULL,
    customer_id integer NOT NULL,
    total_due integer NOT NULL,

);

INSERT INTO orders VALUES (1, '2020-07-21', '2020-07-25', 'submited', 1, 1, 30);
INSERT INTO orders VALUES (2, '2020-07-21', '2020-07-25', 'submited', 2, 3, 30);
INSERT INTO orders VALUES (3, '2020-07-22', '2020-07-26', 'submited', 3, 5, 30);
INSERT INTO orders VALUES (4, '2020-07-22', '2020-07-26', 'submited', 4, 1, 30);
