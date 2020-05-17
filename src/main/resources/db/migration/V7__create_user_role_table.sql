CREATE TABLE IF NOT EXISTS user_role (
    user_id         INTEGER NOT NULL REFERENCES users(id) ON DELETE CASCADE,
    role_id         INTEGER NOT NULL REFERENCES roles(id) ON DELETE CASCADE,
    CONSTRAINT      user_role_pkey PRIMARY KEY (user_id, role_id)
);
