CREATE TABLE IF NOT EXISTS tarifs (
    id              SERIAL PRIMARY KEY,
    tarif_name      VARCHAR (16) NOT NULL,
    price           DOUBLE NOT NULL
)