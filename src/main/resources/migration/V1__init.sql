-- SET search_path TO boot;
CREATE TABLE products (id serial, title varchar(100), price int, count int default 0);

INSERT INTO products (title, price) VALUES ('Bread', 40), ('Milk', 80),('Potato', 70), ('Cheese', 120),
                                           ('Cherry', 150), ('Rice', 40);

CREATE TABLE users (
    username VARCHAR(50) NOT NULL,
    password VARCHAR(100) NOT NULL,
    enabled boolean NOT NULL,
    PRIMARY KEY (username)
);

INSERT INTO users
VALUES
('admin', '{noop}qwerty', true),
('user', '{noop}1234', true);

CREATE TABLE authorities (
    username varchar(50) NOT NULL,
    authority varchar(50) NOT NULL,

    CONSTRAINT authorities_idx UNIQUE (username, authority),

    CONSTRAINT authorities_ibfk_1
    FOREIGN KEY (username)
    REFERENCES users (username)
);

INSERT INTO authorities
VALUES
('admin', 'ROLE_ADMIN'),
('admin', 'ROLE_USER'),
('user', 'ROLE_USER');