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

INSERT INTO user_role (user_id, role_id),
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
        (11, 3),

INSERT INTO states (state_name)
VALUES  ('Вінниця'),
        ('')
        ('')
        ('')
        ('')