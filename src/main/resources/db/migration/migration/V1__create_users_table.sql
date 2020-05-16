CREATE TABLE IF NOT EXISTS users (
    id                  SERIAL PRIMARY KEY,
    first_name          VARCHAR (16) NOT NULL,
    second_name         VARCHAR (16) NOT NULL,
    patronymic          VARCHAR (16) NOT NULL,
    email               VARCHAR (16) UNIQUE NOT NULL,
    password            VARCHAR (128) NOT NULL,
    phone               INTEGER (10) NOT NULL,
    registration_date   DATE NOT NULL
)