CREATE TABLE IF NOT EXISTS cities (
    id              SERIAL PRIMARY KEY,
    state_id        INTEGER NOT NUll REFERENCES states(id) ON DELETE CASCADE,
    city_name       VARCHAR (16) NOT NULL
)