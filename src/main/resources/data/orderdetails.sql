DROP TABLE IF EXISTS orderdetails;

CREATE TABLE orderdetails
(
    sales_order_id integer NOT NULL,
    sales_order_detail_id integer NOT NULL,
    qty integer NOT NULL,
    product_id integer NOT NULL,
    unit_price integer NOT NULL,

);

INSERT INTO orderdetails VALUES (1, 2, 1, 4369, 30);
INSERT INTO orderdetails VALUES (2, 4, 1, 2679, 30);
INSERT INTO orderdetails VALUES (3, 1, 1, 9088, 30);
INSERT INTO orderdetails VALUES (4, 1, 1, 384, 30);

