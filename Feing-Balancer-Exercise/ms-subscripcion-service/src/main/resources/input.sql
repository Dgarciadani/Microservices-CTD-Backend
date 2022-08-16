insert into plans(id, name, price) values (1, 'Basic', 100.00);
insert into plans(id, name, price) values (2, 'Premium', 200.00);

insert into subscriptions(id, end_date, start_date, user_id, plan_id) values (1, '2022-10-01', '2019-01-01', 1, 1);
insert into subscriptions(id, end_date, start_date, user_id, plan_id) values (2, '2022-01-01', '2019-01-01', 2, 2);
