CREATE TABLE IF NOT EXISTS accounts (
    id              SERIAL PRIMARY KEY,
    user_id         INTEGER REFERENCES users(id) ON DELETE CASCADE,
    city_id         INTEGER REFERENCES cities(id) ON DELETE CASCADE,
    tariff_id       INTEGER REFERENCES tariffs(id) ON DELETE CASCADE,
    street          VARCHAR (32) NOT NULL,
    house           INTEGER NOT NULL,
    appartament     INTEGER
)