SELECT *
FROM invoices AS i
    JOIN accounts AS a
    ON i.account_id = a.id
    JOIN users AS u
    ON a.user_id = u.id
    WHERE u.id = ?