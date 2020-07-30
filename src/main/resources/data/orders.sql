DROP TABLE IF EXISTS orders;

CREATE TABLE orders
(
    sales_order_id SERIAL PRIMARY KEY,
    order_date date NOT NULL,
    due_date date NOT NULL,
    status character(20) NOT NULL,
    sales_order_number character(10) NOT NULL,
    user_id integer NOT NULL,
    total_due integer NOT NULL

);

INSERT INTO orders VALUES (1, '2020-07-21', '2020-08-25', 'submited', 'SO44102', 2, 30);
INSERT INTO orders VALUES (2, '2020-07-21', '2020-08-25', 'shipped', 'SO44114', 2, 15);
INSERT INTO orders VALUES (3, '2020-07-22', '2020-08-26', 'shipped', 'SO44147', 3, 20);
INSERT INTO orders VALUES (4, '2020-07-23', '2020-08-26', 'submited', 'SO44153', 12, 15);
SELECT pg_catalog.setval('orders_sales_order_id_seq', 4, true);

INSERT INTO orders (order_date, due_date, status, sales_order_number, user_id, total_due) VALUES ('2020-06-21', '2020-07-21', 'shipped', 'SO43665', 13, 30);
INSERT INTO orders (order_date, due_date, status, sales_order_number, user_id, total_due) VALUES ('2020-06-25', '2020-07-25', 'shipped', 'SO43671', 18, 20);
INSERT INTO orders (order_date, due_date, status, sales_order_number, user_id, total_due) VALUES ('2020-05-21', '2020-06-21', 'shipped', 'SO43674', 15, 20);
INSERT INTO orders (order_date, due_date, status, sales_order_number, user_id, total_due) VALUES ('2020-05-21', '2020-06-21', 'shipped', 'SO43678', 2, 14);
INSERT INTO orders (order_date, due_date, status, sales_order_number, user_id, total_due) VALUES ('2020-05-21', '2020-06-25', 'shipped', 'SO43679', 6, 30);
INSERT INTO orders (order_date, due_date, status, sales_order_number, user_id, total_due) VALUES ('2020-05-21', '2020-07-21', 'shipped', 'SO43680', 9, 20);
INSERT INTO orders (order_date, due_date, status, sales_order_number, user_id, total_due) VALUES ('2020-07-21', '2020-08-25', 'shipped', 'SO43687', 11, 25);
INSERT INTO orders (order_date, due_date, status, sales_order_number, user_id, total_due) VALUES ('2020-07-21', '2020-08-25', 'shipped', 'SO43689', 11, 25);
INSERT INTO orders (order_date, due_date, status, sales_order_number, user_id, total_due) VALUES ('2020-07-21', '2020-08-25', 'shipped', 'SO43700', 14, 22);
INSERT INTO orders (order_date, due_date, status, sales_order_number, user_id, total_due) VALUES ('2020-07-21', '2020-08-25', 'shipped', 'SO43704', 18, 22);
INSERT INTO orders (order_date, due_date, status, sales_order_number, user_id, total_due) VALUES ('2020-07-20', '2020-08-20', 'shipped', 'SO43713', 17, 22);
INSERT INTO orders (order_date, due_date, status, sales_order_number, user_id, total_due) VALUES ('2020-07-19', '2020-06-19', 'shipped', 'SO43721', 3, 12);
INSERT INTO orders (order_date, due_date, status, sales_order_number, user_id, total_due) VALUES ('2020-07-21', '2020-08-21', 'shipped', 'SO43731', 2, 12);
INSERT INTO orders (order_date, due_date, status, sales_order_number, user_id, total_due) VALUES ('2020-07-30', '2020-08-21', 'confirmed', 'SO43741', 9, 17);
INSERT INTO orders (order_date, due_date, status, sales_order_number, user_id, total_due) VALUES ('2020-04-21', '2020-05-21', 'shipped', 'SO43750', 9, 15);
INSERT INTO orders (order_date, due_date, status, sales_order_number, user_id, total_due) VALUES ('2020-07-21', '2020-08-21', 'cancelled', 'SO43753', 9, 22);
INSERT INTO orders (order_date, due_date, status, sales_order_number, user_id, total_due) VALUES ('2020-04-07', '2020-05-07', 'submited', 'SO43760', 7, 23);
INSERT INTO orders (order_date, due_date, status, sales_order_number, user_id, total_due) VALUES ('2020-07-21', '2020-08-21', 'submited', 'SO43765', 2, 22);
INSERT INTO orders (order_date, due_date, status, sales_order_number, user_id, total_due) VALUES ('2020-07-21', '2020-08-21', 'cancelled', 'SO43774', 13, 20);
INSERT INTO orders (order_date, due_date, status, sales_order_number, user_id, total_due) VALUES ('2020-07-21', '2020-08-21', 'shipped', 'SO43785', 12, 30);
INSERT INTO orders (order_date, due_date, status, sales_order_number, user_id, total_due) VALUES ('2020-07-29', '2020-08-29', 'shipped', 'SO43794', 13, 30);
INSERT INTO orders (order_date, due_date, status, sales_order_number, user_id, total_due) VALUES ('2020-07-28', '2020-08-28', 'shipped', 'SO43804', 10, 30);
INSERT INTO orders (order_date, due_date, status, sales_order_number, user_id, total_due) VALUES ('2020-07-21', '2020-08-21', 'shipped', 'SO43806', 10, 30);
INSERT INTO orders (order_date, due_date, status, sales_order_number, user_id, total_due) VALUES ('2020-07-21', '2020-08-21', 'shipped', 'SO43811', 10, 25);
INSERT INTO orders (order_date, due_date, status, sales_order_number, user_id, total_due) VALUES ('2020-07-30', '2020-08-30', 'shipped', 'SO43812', 9, 30);
INSERT INTO orders (order_date, due_date, status, sales_order_number, user_id, total_due) VALUES ('2020-07-21', '2020-08-21', 'shipped', 'SO43820', 7, 20);
INSERT INTO orders (order_date, due_date, status, sales_order_number, user_id, total_due) VALUES ('2020-06-21', '2020-07-21', 'shipped', 'SO43971', 3, 20);
INSERT INTO orders (order_date, due_date, status, sales_order_number, user_id, total_due) VALUES ('2020-06-21', '2020-07-21', 'shipped', 'SO43974', 16, 30);
INSERT INTO orders (order_date, due_date, status, sales_order_number, user_id, total_due) VALUES ('2020-06-21', '2020-07-21', 'shipped', 'SO43994', 15, 15);
INSERT INTO orders (order_date, due_date, status, sales_order_number, user_id, total_due) VALUES ('2020-06-21', '2020-07-21', 'shipped', 'SO44019', 11, 30);



