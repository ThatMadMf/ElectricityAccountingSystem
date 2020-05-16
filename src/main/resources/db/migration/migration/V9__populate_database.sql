INSERT INTO roles (role)
VALUES  ('SUPER_ADMIN'),
        ('ADMIN'),
        ('USER');

INSERT INTO users (second_name, first_name, patronymic, email, password, phone, registration_date)
VALUES  ('ADMIN', 'ADMIN', 'ADMIN', 'admin@gmail.com', 'admin_pass', 123456789,  current_date - 4),
        ('Попов', 'Йоханес', 'Юхимович', 'popov@gmail.com', 'temp_pas', 123456789, current_date - 3),
        ('Лапин', 'Чарльз', 'Романович', 'lapin@gmail.com', 'temp_pas', 123456789, current_date - 3),
        ('Мамонтов', 'Филипп', 'Андреевич', 'manontov@gmail.com', 'temp_pas', 123456789, current_date - 3),
        ('Мартынов', 'Устин ', 'Петрович', 'martinov@gmail.com', 'temp_pas', 123456789, current_date - 3),
        ('Николаев', 'Эдуард', 'Максимович', 'nikolaev@gmail.com', 'temp_pas', 123456789, current_date - 3),
        ('Колесник', 'Харитон', 'Михайлович', 'kolesnic@gmail.com', 'temp_pas', 123456789, current_date - 3),
        ('Симонов', 'Руслан', 'Фёдорович', 'simonov@gmail.com', 'temp_pas', 123456789, current_date - 3),
        ('Дементьев', 'Герман', 'Фёдорович', 'dementev@gmail.com', 'temp_pas', 123456789, current_date - 3),
        ('Котов', 'Евстахий', 'Эдуардович', 'kotov@gmail.com', 'temp_pas', 123456789, current_date - 3),
        ('Выговский', 'Жигер', 'Максимович', 'vigovsky@gmail.com', 'temp_pas', 123456789, current_date - 3);

INSERT INTO user_role (user_id, role_id)
VALUES  (1, 1),
        (2, 2),
        (3, 2),
        (4, 3),
        (5, 3),
        (6, 3),
        (7, 3),
        (8, 3),
        (9, 3),
        (10, 3),
        (11, 3);

INSERT INTO states (state_name)
VALUES  ('Київська область'),
        ('Черкаська область'),
        ('Вінницька область'),
        ('Дніпропетровська область'),
        ('Донецька область'),
        ('Житомирська область'),
        ('Запоріжська область'),
        ('Івано-Франківська область');

INSERT INTO cities (state_id, city_name)
VALUES  (1, 'Київ'),
        (2, 'Черкаси');

INSERT INTO tariffs (tariff_name, price)
VALUES  ('Пільги', 3),
        ('Економ', 5),
        ('Дорого', 11);

INSERT INTO accounts (user_id, city_id, tariff_id, street, house, appartament)
VALUES  (4, 1, 3, 'Вулиця Києва', 69, 2),
        (5, 1, 3, 'Вулиця Києва', 96, 12),
        (6, 1, 3, 'Вулиця Києва', 66, 98),
        (7, 1, 2, 'Інша вулиця Києва', 66, 21),
        (8, 1, 2, 'Інша вулиця Києва', 33, 33),
        (9, 1, 2, 'Інша вулиця Києва', 15, 79),
        (10, 2, 1, 'Вулиця Черкасс', 3, NULL),
        (11, 2, 1, 'Вулиця Черкасс', 55, 22);

INSERT INTO invoices (account_id, electricity_units, invoice_date)
VALUES  (1, 32.4, current_date - 2),
        (4, 23.1, current_date - 2),
        (8, 44.2, current_date - 2);