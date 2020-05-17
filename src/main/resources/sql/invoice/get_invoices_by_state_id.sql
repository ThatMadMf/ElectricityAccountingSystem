SELECT i.*
FROM invoices AS i
    JOIN accounts AS a
    ON i.account_id = a.id
    JOIN cities AS c
    ON a.city_id = c.id
    JOIN states AS s
    ON c.state_id = s.id
    WHERE s.id = ?