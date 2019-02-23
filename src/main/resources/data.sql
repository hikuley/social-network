
-- MOCK USER DATA

insert into
        User
        (create_date_time, update_date_time, email, first_name, last_name, nick_name, password, id)
    values
        ('2019-02-12 19:23:42.836', '2019-02-12 19:23:42.836', 'test@gmail.com', 'Halil', 'Küley', 'hikuley', '1234', 1);

insert into
        User
        (create_date_time, update_date_time, email, first_name, last_name, nick_name, password, id)
    values
        ('2019-02-12 19:23:42.836', '2019-02-12 19:23:42.836', 'test@gmail.com', 'John', 'Papa', 'johnCrazy', '1234', 2);

insert into
        User
        (create_date_time, update_date_time, email, first_name, last_name, nick_name, password, id)
    values
        ('2019-02-12 19:23:42.836', '2019-02-12 19:23:42.836', 'test@gmail.com', 'Maria', 'Capol', 'maria123', '1234', 3);

insert into
        User
        (create_date_time, update_date_time, email, first_name, last_name, nick_name, password, id)
    values
        ('2019-02-12 19:23:42.836', '2019-02-12 19:23:42.836', 'test@gmail.com', 'Co', 'Father', 'co44', '1234', 4);

insert into
        User
        (create_date_time, update_date_time, email, first_name, last_name, nick_name, password, id)
    values
        ('2019-02-12 19:23:42.836', '2019-02-12 19:23:42.836', 'test@gmail.com', 'Inka', 'saga', 'inka22', '1234', 5);

-- MOCK MESSAGE DATA

insert
    into
        message
        (id, create_date_time, update_date_time, message, user_id)
    values
        (1, '2019-02-12 19:23:42.836', '2019-02-12 19:23:42.836', 'Poland is very beautiful country.', 1);

insert
    into
        message
        (id, create_date_time, update_date_time, message, user_id)
    values
        (2, '2019-02-12 19:23:42.836', '2019-02-12 19:23:42.836', 'Poland has a lot of very beautiful cities.', 2);

insert
    into
        message
        (id, create_date_time, update_date_time, message, user_id)
    values
        (3, '2019-02-12 19:23:42.836', '2019-02-12 19:23:42.836', 'I want to build a relax life in Poland.', 3);

insert
    into
        message
        (id, create_date_time, update_date_time, message, user_id)
    values
        (4, '2019-02-12 19:23:42.836', '2019-02-12 19:23:42.836', 'Fenerbahce Champion', 4);

insert
    into
        message
        (id, create_date_time, update_date_time, message, user_id)
    values
        (5, '2019-02-12 19:23:42.836', '2019-02-12 19:23:42.836', 'I would like to learn the history of Poland.', 5);

-- MOCK FOLLOW DATA

insert
    into
        follow
        (id, create_date_time, update_date_time, who_id, to_id)
    values
        (1, '2019-02-12 19:23:42.836', '2019-02-12 19:23:42.836', 1, 2);
insert
    into
        follow
        (id, create_date_time, update_date_time, who_id, to_id)
    values
        (2, '2019-02-12 19:23:42.836', '2019-02-12 19:23:42.836', 1, 3);
insert
    into
        follow
        (id, create_date_time, update_date_time, who_id, to_id)
    values
        (3, '2019-02-12 19:23:42.836', '2019-02-12 19:23:42.836', 1, 4);
insert
    into
        follow
        (id, create_date_time, update_date_time, who_id, to_id)
    values
        (4, '2019-02-12 19:23:42.836', '2019-02-12 19:23:42.836', 1, 5);
