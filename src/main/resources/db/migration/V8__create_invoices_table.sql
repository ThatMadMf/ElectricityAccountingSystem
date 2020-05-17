CREATE TABLE IF NOT EXISTS invoices (
    id                  SERIAL PRIMARY KEY,
    account_id          INTEGER NOT NULL REFERENCES accounts(id) ON DELETE CASCADE,
    electricity_units   DECIMAL NOT NULL,
    invoice_date        DATE NOT NUll
)