DROP TABLE IF EXISTS cart;

CREATE TABLE cart (
    id SERIAL PRIMARY KEY,
    user_id integer NOT NULL,
    product_id integer NOT NULL,
    quantity integer NOT NULL
);