CREATE TABLE IF NOT EXISTS tariffs (
    id              SERIAL PRIMARY KEY,
    tariff_name     VARCHAR (16) NOT NULL,
    price           DECIMAL NOT NULL
)