SELECT u.login as login, u.password as password, r.role as role
FROM users AS u
LEFT JOIN user_role AS ur
    ON ur.user_id = u.id
    JOIN roles AS r
    ON r.id = ur.role_id
    WHERE u.login = ?