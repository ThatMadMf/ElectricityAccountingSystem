CREATE TABLE IF NOT EXISTS users (
    id                  SERIAL PRIMARY KEY,
    first_name          VARCHAR (32) NOT NULL,
    second_name         VARCHAR (32) NOT NULL,
    patronymic          VARCHAR (32) NOT NULL,
    email               VARCHAR (32) UNIQUE NOT NULL,
    password            VARCHAR (128) NOT NULL,
    phone               INTEGER NOT NULL,
    registration_date   DATE NOT NULL
)