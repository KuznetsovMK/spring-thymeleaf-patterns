insert into account_user (password, username, firstname, lastname, account_non_expired, account_non_locked,
                          credentials_non_expired, enabled)
values ('$2a$10$k/YomPIfS0R/6y8fcOGfZ.VrV9QOmKmOHADIju.ig2Gzje1FBA57.', 'user', 'Иван', 'Иванов', true, true, true, true),
('$2a$10$vJXhq/i01E8R31smFN1YSe5k/eB2mrgCq3DdrWM95Q.SOnm55/4..', 'admin', 'Петр', 'Иванов', true, true, true, true);

insert into authority (role)
values ('USER'),
       ('ADMIN');

insert into user_authority (user_id, authority_id)
values (1, 1),
       (2, 2);