delete from bank.user;

insert into bank.user (login)
values ('aaa'),
       ('bbb'),
       ('ccc'),
       ('ddd'),
       ('eee'),
       ('fff'),
       ('ggg'),
       ('hhh'),
       ('iii'),
       ('jjj');

delete from bank.account;
insert into bank.account (money_amount, user_id)
values (101, 1),
       (102, 1),
       (102, 2),
       (102, 2),
       (102, 3),
       (102, 3),
       (102, 4),
       (102, 4),
       (102, 5),
       (102, 5),
       (102, 6),
       (102, 6),
       (102, 7),
       (102, 7),
       (102, 8),
       (102, 8),
       (102, 9),
       (102, 9),
       (102, 10),
       (102, 10);