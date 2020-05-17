SELECT a.id AS id, c.city_name AS city, t.tariff_name AS tariffName, street, house, apartment
FROM accounts AS a
    JOIN cities AS c
    ON a.city_id = c.id
    JOIN tariffs AS t
    ON a.tariff_id = t.id
    WHERE a.user_id = ?