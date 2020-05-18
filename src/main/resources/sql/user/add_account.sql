INSERT INTO accounts (user_id, city_id, tariff_id, street, house, apartment)
VALUES  (
            ?,
            SELECT cities.id FROM cities WHERE city_name = ?,
            SELECT tariffs.id FROM tariffs WHERE tariff_name = ?,
            ?,
            ?,
            ?
        )