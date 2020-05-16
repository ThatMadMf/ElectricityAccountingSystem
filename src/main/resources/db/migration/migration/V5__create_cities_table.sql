CREATE TABLE IF NOT EXISTS cities (
    id              SERIAL PRIMARY KEY,
    state_id        INTEGER REFERENCES states(id) NOT NUll ON DELETE CASCADE,
    city_name       VARCHAR (16) NOT NULL
)