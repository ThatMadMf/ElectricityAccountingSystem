INSERT INTO accounts (user_id, city_id, tariff_id, street, house, apartment)
    SELECT ?, c.id, t.id, ?, ?, ?
    FROM cities AS c, tariffs AS t
    WHERE c.city_name = ? AND t.tariff_name = ?;