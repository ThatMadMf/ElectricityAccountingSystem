SELECT i.*
FROM invoices AS i
    JOIN accounts AS a
    ON i.account_id = a.id
    WHERE a.city_id = ?