DROP TABLE IF EXISTS cart;

CREATE TABLE cart (
    id SERIAL PRIMARY KEY,
    user_id integer NOT NULL,
    product_id integer NOT NULL,
    quantity integer NOT NULL
);

INSERT INTO cart VALUES (1, 2, 8323, 1);
INSERT INTO cart VALUES (2, 2, 4253, 2);
INSERT INTO cart VALUES (3, 5, 5486, 1);
INSERT INTO cart VALUES (4, 6, 803, 4);