-- insert into bankapp.manager (m_id, m_first_name, m_last_name, m_status, m_create_at, m_update_at) values ('1763f054-5393-11ee-8c99-0242ac120002', 'Vasiliy', 'Pupkin', 1, '2023-12-28 13:24:51', '2023-12-28 13:24:59');
-- insert into bankapp.manager (m_id, m_first_name, m_last_name, m_status, m_create_at, m_update_at) values ('caed40d0-5401-11ee-8c99-0242ac120002', 'Jon', 'Smith', 2, '2023-12-25 13:27:41', '2023-12-27 13:27:50');
-- insert into bankapp.manager (m_id, m_first_name, m_last_name, m_status, m_create_at, m_update_at) values ('f74cf29c-5401-11ee-8c99-0242ac120002', 'Michail', 'Lei', 3, '2023-12-25 13:29:25', null);

insert into bankapp.manager (m_first_name, m_last_name, m_status) values ( 'Vasiliy', 'Pupkin', 1);
insert into bankapp.manager (m_first_name, m_last_name, m_status) values ( 'Jon', 'Smith', 2);
insert into bankapp.manager (m_first_name, m_last_name, m_status) values ( 'Michail', 'Lei', 3);
--
-- insert into bankapp.product (p_id, p_manager_id, p_name, p_status, p_currency_code, p_interest_rate, p_limit_, p_create_at, p_update_at) values ('06c2f173-4fac-4520-8666-58c379171019', 'caed40d0-5401-11ee-8c99-0242ac120002', 'DEBIT_CARD', 1, 2, 2.2500, 20000, '2023-12-28 14:29:42', null);
-- insert into bankapp.product (p_id, p_manager_id, p_name, p_status, p_currency_code, p_interest_rate, p_limit_, p_create_at, p_update_at) values ('261241cb-f206-4b29-a779-6fe116538763', '1763f054-5393-11ee-8c99-0242ac120002', 'DEPOSIT', 1, 1, 2.7500, 10000, '2023-12-28 14:01:01', null);
-- insert into bankapp.product (p_id, p_manager_id, p_name, p_status, p_currency_code, p_interest_rate, p_limit_, p_create_at, p_update_at) values ('b94c7073-f7c7-454e-8ca7-0180e8f580d1', 'f74cf29c-5401-11ee-8c99-0242ac120002', 'CREDIT_CARD', 1, 3, 2.0000, 30000, '2023-12-28 14:31:33', null);

insert into bankapp.product (p_manager_id, p_name, p_status, p_currency_code, p_interest_rate, p_limit_) values ((select manager.m_id from manager order by RAND() LIMIT 1), 'DEBIT_CARD', 1, 2, 2.2500, 20000);
insert into bankapp.product (p_manager_id, p_name, p_status, p_currency_code, p_interest_rate, p_limit_) values ((select manager.m_id from manager order by RAND() LIMIT 1), 'DEPOSIT', 1, 1, 2.7500, 10000);
insert into bankapp.product (p_manager_id, p_name, p_status, p_currency_code, p_interest_rate, p_limit_) values ((select manager.m_id from manager order by RAND() LIMIT 1), 'CREDIT_CARD', 1, 3, 2.0000, 30000);

-- insert into bankapp.product (p_id, p_manager_id, p_name, p_status, p_currency_code, p_interest_rate, p_limit_, p_create_at, p_update_at) values ('06c2f173-4fac-4520-8666-58c379171019', 'caed40d0-5401-11ee-8c99-0242ac120002', 'DEBIT_CARD', 1, 2, 2.2500, 20000, '2023-12-28 14:29:42', null);
-- insert into bankapp.product (p_id, p_manager_id, p_name, p_status, p_currency_code, p_interest_rate, p_limit_, p_create_at, p_update_at) values ('261241cb-f206-4b29-a779-6fe116538763', '1763f054-5393-11ee-8c99-0242ac120002', 'DEPOSIT', 1, 1, 2.7500, 10000, '2023-12-28 14:01:01', null);
-- insert into bankapp.product (p_id, p_manager_id, p_name, p_status, p_currency_code, p_interest_rate, p_limit_, p_create_at, p_update_at) values ('b94c7073-f7c7-454e-8ca7-0180e8f580d1', 'f74cf29c-5401-11ee-8c99-0242ac120002', 'CREDIT_CARD', 1, 3, 2.0000, 30000, '2023-12-28 14:31:33', null);

insert into bankapp.client (c_manager_id, c_status, c_tax_code, c_first_name, c_last_name, c_email, c_address, c_phone) values ((select manager.m_id from manager order by RAND() LIMIT 1), 0, '6546645656', 'Kon', 'Pedalniy', 'kp@mail.ru', '1254 Birulovo', '095-987-9898');
insert into bankapp.client (c_manager_id, c_status, c_tax_code, c_first_name, c_last_name, c_email, c_address, c_phone) values ((select manager.m_id from manager order by RAND() LIMIT 1), 1, '5453243434', 'Ivan', 'Petrov', 'ip@gmail.com', '43 Col Street', '493-236-6155');
insert into bankapp.client (c_manager_id, c_status, c_tax_code, c_first_name, c_last_name, c_email, c_address, c_phone) values ((select manager.m_id from manager order by RAND() LIMIT 1), 3, '5664454533', 'Abram', 'Kazman', 'ak@zahav.co.il', '21 Dizengoff Street', '254-748-6911');
insert into bankapp.client (c_manager_id, c_status, c_tax_code, c_first_name, c_last_name, c_email, c_address, c_phone) values ((select manager.m_id from manager order by RAND() LIMIT 1), 0, '5653533343', 'Anna', 'Smirnova', 'as@barbi.com', '69 Nyk', '111-111-1111');
insert into bankapp.client (c_manager_id, c_status, c_tax_code, c_first_name, c_last_name, c_email, c_address, c_phone) values ((select manager.m_id from manager order by RAND() LIMIT 1), 0, '7476645654', 'Pol', 'Makartny', 'pm@usa.com', '15 Brodway Street', '001-233-4564');
insert into bankapp.client (c_manager_id, c_status, c_tax_code, c_first_name, c_last_name, c_email, c_address, c_phone) values ((select manager.m_id from manager order by RAND() LIMIT 1), 0, '1234567899', 'Vasiliy', 'Ivanov', 'vi@gmail.com', '82 Partisan Pass', '495-203-2220');
insert into bankapp.client (c_manager_id, c_status, c_tax_code, c_first_name, c_last_name, c_email, c_address, c_phone) values ((select manager.m_id from manager order by RAND() LIMIT 1), 2, '8768769657', 'Los', 'Prostolos', 'lp@rambler.ru', '1 Lesnaya Chascha', '554-650-2593');
insert into bankapp.client (c_manager_id, c_status, c_tax_code, c_first_name, c_last_name, c_email, c_address, c_phone) values ((select manager.m_id from manager order by RAND() LIMIT 1), 0, '4543534567', 'Pol', 'Zayzev', 'pz@dtelecom.de', '33 Banhofstrasse', '349-543-4556');
insert into bankapp.client (c_manager_id, c_status, c_tax_code, c_first_name, c_last_name, c_email, c_address, c_phone) values ((select manager.m_id from manager order by RAND() LIMIT 1), 0, '4324245666', 'James', 'Bond', 'jb@mail.ru', '32 Pavelezciy Vokzal', '617-320-1724');
insert into bankapp.client (c_manager_id, c_status, c_tax_code, c_first_name, c_last_name, c_email, c_address, c_phone) values ((select manager.m_id from manager order by RAND() LIMIT 1), 3, '9845543345', 'Masha', 'Rasputina', 'mr@gmail.com', '1 Gum Krasnaya Ploshad', '543-553-5443');

-- insert into bankapp.client (c_id, c_manager_id, c_status, c_tax_code, c_first_name, c_last_name, c_email, c_address, c_phone, c_create_at, c_update_at) values ('5308ec41-c4c2-46ec-8831-d20e417e0f6c', '1763f054-5393-11ee-8c99-0242ac120002', 0, '6546645656', 'Kon', 'Pedalniy', 'kp@mail.ru', '1254 Birulovo', '095-987-9898', '2023-12-28 15:39:50', null);
-- insert into bankapp.client (c_id, c_manager_id, c_status, c_tax_code, c_first_name, c_last_name, c_email, c_address, c_phone, c_create_at, c_update_at) values ('53de66be-9648-4545-b399-00970aec0a43', '1763f054-5393-11ee-8c99-0242ac120002', 1, '5453243434', 'Ivan', 'Petrov', 'ip@gmail.com', '43 Col Street', '493-236-6155', '2023-12-28 15:15:46', null);
-- insert into bankapp.client (c_id, c_manager_id, c_status, c_tax_code, c_first_name, c_last_name, c_email, c_address, c_phone, c_create_at, c_update_at) values ('6b6eb8fd-64c5-457f-be98-edb1a54fbbcd', '1763f054-5393-11ee-8c99-0242ac120002', 3, '5664454533', 'Abram', 'Kazman', 'ak@zahav.co.il', '21 Dizengoff Street', '254-748-6911', '2023-12-28 15:26:22', null);
-- insert into bankapp.client (c_id, c_manager_id, c_status, c_tax_code, c_first_name, c_last_name, c_email, c_address, c_phone, c_create_at, c_update_at) values ('80753c19-2d26-434a-8eef-b13a5caaa5c1', 'f74cf29c-5401-11ee-8c99-0242ac120002', 0, '5653533343', 'Anna', 'Smirnova', 'as@barbi.com', '69 Nyk', '111-111-1111', '2023-12-28 15:42:38', null);
-- insert into bankapp.client (c_id, c_manager_id, c_status, c_tax_code, c_first_name, c_last_name, c_email, c_address, c_phone, c_create_at, c_update_at) values ('96b99d2e-0621-472b-b354-5e6811605f6e', 'caed40d0-5401-11ee-8c99-0242ac120002', 0, '7476645654', 'Pol', 'Makartny', 'pm@usa.com', '15 Brodway Street', '001-233-4564', '2023-12-28 15:32:02', null);
-- insert into bankapp.client (c_id, c_manager_id, c_status, c_tax_code, c_first_name, c_last_name, c_email, c_address, c_phone, c_create_at, c_update_at) values ('9921c0fa-e9ca-4bd8-b763-abb459a00bd9', '1763f054-5393-11ee-8c99-0242ac120002', 0, '1234567899', 'Vasiliy', 'Ivanov', 'vi@gmail.com', '82 Partisan Pass', '495-203-2220', '2023-12-28 15:12:43', null);
-- insert into bankapp.client (c_id, c_manager_id, c_status, c_tax_code, c_first_name, c_last_name, c_email, c_address, c_phone, c_create_at, c_update_at) values ('d62c0f9c-50b4-48ab-96b9-7c81dd04ac48', 'f74cf29c-5401-11ee-8c99-0242ac120002', 2, '8768769657', 'Los', 'Prostolos', 'lp@rambler.ru', '1 Lesnaya Chascha', '554-650-2593', '2023-12-28 15:21:52', null);
-- insert into bankapp.client (c_id, c_manager_id, c_status, c_tax_code, c_first_name, c_last_name, c_email, c_address, c_phone, c_create_at, c_update_at) values ('ea1e1733-bb66-4b6c-ace8-096226960ff1', 'f74cf29c-5401-11ee-8c99-0242ac120002', 0, '4543534567', 'Pol', 'Zayzev', 'pz@dtelecom.de', '33 Banhofstrasse', '349-543-4556', '2023-12-28 15:29:30', null);
-- insert into bankapp.client (c_id, c_manager_id, c_status, c_tax_code, c_first_name, c_last_name, c_email, c_address, c_phone, c_create_at, c_update_at) values ('f3deef15-86da-46ec-9d27-8305dc37e6a4', 'caed40d0-5401-11ee-8c99-0242ac120002', 0, '4324245666', 'James', 'Bond', 'jb@mail.ru', '32 Pavelezciy Vokzal', '617-320-1724', '2023-12-28 15:19:04', null);
-- insert into bankapp.client (c_id, c_manager_id, c_status, c_tax_code, c_first_name, c_last_name, c_email, c_address, c_phone, c_create_at, c_update_at) values ('f68a90a0-d3b0-4479-bda4-4acb7513b0b3', 'caed40d0-5401-11ee-8c99-0242ac120002', 3, '9845543345', 'Masha', 'Rasputina', 'mr@gmail.com', '1 Gum Krasnaya Ploshad', '543-553-5443', '2023-12-28 15:34:33', null);
--
insert into bankapp.account (a_client_id, a_account_number, a_type, a_status, a_balance, a_currency_code) values ((select client.c_id from client order by RAND() LIMIT 1), '123456789', 0, 1, 2222.00, 1);
insert into bankapp.account (a_client_id, a_account_number, a_type, a_status, a_balance, a_currency_code) values ((select client.c_id from client order by RAND() LIMIT 1), '211111111', 0, 1, 2322.00, 0);
insert into bankapp.account (a_client_id, a_account_number, a_type, a_status, a_balance, a_currency_code) values ((select client.c_id from client order by RAND() LIMIT 1), '411111111', 2, 1, 11.00, 4);
insert into bankapp.account (a_client_id, a_account_number, a_type, a_status, a_balance, a_currency_code) values ((select client.c_id from client order by RAND() LIMIT 1), '211111111', 0, 1, 1312111.00, 3);
insert into bankapp.account (a_client_id, a_account_number, a_type, a_status, a_balance, a_currency_code) values ((select client.c_id from client order by RAND() LIMIT 1), '711111111', 2, 1, 43242.00, 2);
insert into bankapp.account (a_client_id, a_account_number, a_type, a_status, a_balance, a_currency_code) values ((select client.c_id from client order by RAND() LIMIT 1), '511111111', 3, 1, 2222.00, 5);
insert into bankapp.account (a_client_id, a_account_number, a_type, a_status, a_balance, a_currency_code) values ((select client.c_id from client order by RAND() LIMIT 1), '611111111', 4, 1, 0.00, 0);
insert into bankapp.account (a_client_id, a_account_number, a_type, a_status, a_balance, a_currency_code) values ((select client.c_id from client order by RAND() LIMIT 1), '311111111', 1, 1, 12333.00, 2);
insert into bankapp.account (a_client_id, a_account_number, a_type, a_status, a_balance, a_currency_code) values ((select client.c_id from client order by RAND() LIMIT 1), '811111111', 3, 1, 423423.00, 4);
insert into bankapp.account (a_client_id, a_account_number, a_type, a_status, a_balance, a_currency_code) values ((select client.c_id from client order by RAND() LIMIT 1), '111111111', 1, 1, 2222111.00, 1);

-- insert into bankapp.account (a_id, a_client_id, a_account_number, a_type, a_status, a_balance, a_currency_code, a_create_at, a_update_at) values ('0c70afa1-c654-471d-9cb2-437ac289d62c', '9921c0fa-e9ca-4bd8-b763-abb459a00bd9', '123456789', 0, 1, 2222.00, 1, '2023-12-28 15:55:22', null);
-- insert into bankapp.account (a_id, a_client_id, a_account_number, a_type, a_status, a_balance, a_currency_code, a_create_at, a_update_at) values ('23a1d7a0-995f-44d2-b401-c56e1b2c6023', '96b99d2e-0621-472b-b354-5e6811605f6e', '211111111', 0, 1, 2322.00, 0, '2023-12-28 16:09:13', null);
-- insert into bankapp.account (a_id, a_client_id, a_account_number, a_type, a_status, a_balance, a_currency_code, a_create_at, a_update_at) values ('4864f038-580e-452e-a661-8a49f0e11cd9', 'd62c0f9c-50b4-48ab-96b9-7c81dd04ac48', '411111111', 2, 1, 11.00, 4, '2023-12-28 16:01:56', null);
-- insert into bankapp.account (a_id, a_client_id, a_account_number, a_type, a_status, a_balance, a_currency_code, a_create_at, a_update_at) values ('5bf54fcd-9a6c-4727-aac6-f3101b2555fa', 'f3deef15-86da-46ec-9d27-8305dc37e6a4', '211111111', 0, 1, 1312111.00, 3, '2023-12-28 16:00:11', null);
-- insert into bankapp.account (a_id, a_client_id, a_account_number, a_type, a_status, a_balance, a_currency_code, a_create_at, a_update_at) values ('602f0704-d25d-4e8b-b559-4ce7c555df93', '5308ec41-c4c2-46ec-8831-d20e417e0f6c', '711111111', 2, 1, 43242.00, 2, '2023-12-28 16:12:19', null);
-- insert into bankapp.account (a_id, a_client_id, a_account_number, a_type, a_status, a_balance, a_currency_code, a_create_at, a_update_at) values ('a5715090-d6f7-49e9-8b65-505284bf8ade', '6b6eb8fd-64c5-457f-be98-edb1a54fbbcd', '511111111', 3, 1, 2222.00, 5, '2023-12-28 16:03:47', null);
-- insert into bankapp.account (a_id, a_client_id, a_account_number, a_type, a_status, a_balance, a_currency_code, a_create_at, a_update_at) values ('b3ce2779-8dbf-487f-b43e-b7af5c1dac97', 'ea1e1733-bb66-4b6c-ace8-096226960ff1', '611111111', 4, 1, 0.00, 0, '2023-12-28 16:06:49', null);
-- insert into bankapp.account (a_id, a_client_id, a_account_number, a_type, a_status, a_balance, a_currency_code, a_create_at, a_update_at) values ('b9f69f21-b390-4783-b5f1-3c700be89bc4', '53de66be-9648-4545-b399-00970aec0a43', '311111111', 1, 1, 12333.00, 2, '2023-12-28 15:58:04', null);
-- insert into bankapp.account (a_id, a_client_id, a_account_number, a_type, a_status, a_balance, a_currency_code, a_create_at, a_update_at) values ('cad16388-2f41-448f-a991-aa75b13dd005', '80753c19-2d26-434a-8eef-b13a5caaa5c1', '811111111', 3, 1, 423423.00, 4, '2023-12-28 16:13:59', null);
-- insert into bankapp.account (a_id, a_client_id, a_account_number, a_type, a_status, a_balance, a_currency_code, a_create_at, a_update_at) values ('df2de6a0-1723-486a-a3e6-07d31e638df5', 'f68a90a0-d3b0-4479-bda4-4acb7513b0b3', '111111111', 1, 1, 2222111.00, 1, '2023-12-28 16:10:40', null);

insert into bankapp.agreement (ag_account_id, ag_product_id, ag_interest_rate, ag_status, ag_sum) values ((select account.a_id from account order by RAND() LIMIT 1), (select product.p_id from product order by RAND() LIMIT 1), 1.2500, 0, 1000.00);
insert into bankapp.agreement (ag_account_id, ag_product_id, ag_interest_rate, ag_status, ag_sum) values ((select account.a_id from account order by RAND() LIMIT 1), (select product.p_id from product order by RAND() LIMIT 1), 1.2000, 1, 200.00);
insert into bankapp.agreement (ag_account_id, ag_product_id, ag_interest_rate, ag_status, ag_sum) values ((select account.a_id from account order by RAND() LIMIT 1), (select product.p_id from product order by RAND() LIMIT 1), 1.2500, 2, 10000.00);
insert into bankapp.agreement (ag_account_id, ag_product_id, ag_interest_rate, ag_status, ag_sum) values ((select account.a_id from account order by RAND() LIMIT 1), (select product.p_id from product order by RAND() LIMIT 1), 1.2200, 3, 2100.00);
insert into bankapp.agreement (ag_account_id, ag_product_id, ag_interest_rate, ag_status, ag_sum) values ((select account.a_id from account order by RAND() LIMIT 1), (select product.p_id from product order by RAND() LIMIT 1), 1.0000, 4, 10000.00);
insert into bankapp.agreement (ag_account_id, ag_product_id, ag_interest_rate, ag_status, ag_sum) values ((select account.a_id from account order by RAND() LIMIT 1), (select product.p_id from product order by RAND() LIMIT 1), 1.2000, 0, 12002.00);
insert into bankapp.agreement (ag_account_id, ag_product_id, ag_interest_rate, ag_status, ag_sum) values ((select account.a_id from account order by RAND() LIMIT 1), (select product.p_id from product order by RAND() LIMIT 1), 1.2500, 2, 300.00);
insert into bankapp.agreement (ag_account_id, ag_product_id, ag_interest_rate, ag_status, ag_sum) values ((select account.a_id from account order by RAND() LIMIT 1), (select product.p_id from product order by RAND() LIMIT 1), 1.2000, 3, 1100.00);
insert into bankapp.agreement (ag_account_id, ag_product_id, ag_interest_rate, ag_status, ag_sum) values ((select account.a_id from account order by RAND() LIMIT 1), (select product.p_id from product order by RAND() LIMIT 1), 1.2220, 4, 100.00);
insert into bankapp.agreement (ag_account_id, ag_product_id, ag_interest_rate, ag_status, ag_sum) values ((select account.a_id from account order by RAND() LIMIT 1), (select product.p_id from product order by RAND() LIMIT 1), 1.0000, 0, 1450.00);
insert into bankapp.agreement (ag_account_id, ag_product_id, ag_interest_rate, ag_status, ag_sum) values ((select account.a_id from account order by RAND() LIMIT 1), (select product.p_id from product order by RAND() LIMIT 1), 1.0000, 1, 1000.00);
insert into bankapp.agreement (ag_account_id, ag_product_id, ag_interest_rate, ag_status, ag_sum) values ((select account.a_id from account order by RAND() LIMIT 1), (select product.p_id from product order by RAND() LIMIT 1), 1.2500, 2, 2222.00);
insert into bankapp.agreement (ag_account_id, ag_product_id, ag_interest_rate, ag_status, ag_sum) values ((select account.a_id from account order by RAND() LIMIT 1), (select product.p_id from product order by RAND() LIMIT 1), 1.0000, 0, 300.00);
insert into bankapp.agreement (ag_account_id, ag_product_id, ag_interest_rate, ag_status, ag_sum) values ((select account.a_id from account order by RAND() LIMIT 1), (select product.p_id from product order by RAND() LIMIT 1), 1.0000, 3, 1000.00);
insert into bankapp.agreement (ag_account_id, ag_product_id, ag_interest_rate, ag_status, ag_sum) values ((select account.a_id from account order by RAND() LIMIT 1), (select product.p_id from product order by RAND() LIMIT 1), 1.0000, 3, 200.00);
insert into bankapp.agreement (ag_account_id, ag_product_id, ag_interest_rate, ag_status, ag_sum) values ((select account.a_id from account order by RAND() LIMIT 1), (select product.p_id from product order by RAND() LIMIT 1), 1.2000, 0, 1000.00);
insert into bankapp.agreement (ag_account_id, ag_product_id, ag_interest_rate, ag_status, ag_sum) values ((select account.a_id from account order by RAND() LIMIT 1), (select product.p_id from product order by RAND() LIMIT 1), 1.0000, 0, 500.00);
insert into bankapp.agreement (ag_account_id, ag_product_id, ag_interest_rate, ag_status, ag_sum) values ((select account.a_id from account order by RAND() LIMIT 1), (select product.p_id from product order by RAND() LIMIT 1), 1.2500, 4, 1000.00);
insert into bankapp.agreement (ag_account_id, ag_product_id, ag_interest_rate, ag_status, ag_sum) values ((select account.a_id from account order by RAND() LIMIT 1), (select product.p_id from product order by RAND() LIMIT 1), 1.1000, 0, 2500.00);
--
-- insert into bankapp.agreement (ag_id, ag_account_id, ag_product_id, ag_interest_rate, ag_status, ag_sum, ag_create_at, ag_update_at) values ('7bf29834-a48b-4e2a-b023-d99e35f3e3b8', '0c70afa1-c654-471d-9cb2-437ac289d62c', '06c2f173-4fac-4520-8666-58c379171019', 1.2500, 0, 1000.00, '2023-12-28 19:13:56', null);
-- insert into bankapp.agreement (ag_id, ag_account_id, ag_product_id, ag_interest_rate, ag_status, ag_sum, ag_create_at, ag_update_at) values ('d965c068-4d54-4382-ac62-7f2db627dc6c', '23a1d7a0-995f-44d2-b401-c56e1b2c6023', '261241cb-f206-4b29-a779-6fe116538763', 1.2000, 1, 200.00, '2023-12-28 19:23:39', null);
-- insert into bankapp.agreement (ag_id, ag_account_id, ag_product_id, ag_interest_rate, ag_status, ag_sum, ag_create_at, ag_update_at) values ('21772977-4026-47ca-b124-523a489307ee', '4864f038-580e-452e-a661-8a49f0e11cd9', 'b94c7073-f7c7-454e-8ca7-0180e8f580d1', 1.2500, 2, 10000.00, '2023-12-28 19:25:46', null);
-- insert into bankapp.agreement (ag_id, ag_account_id, ag_product_id, ag_interest_rate, ag_status, ag_sum, ag_create_at, ag_update_at) values ('556330ef-b019-4744-923e-cffe7c7e5cd4', '5bf54fcd-9a6c-4727-aac6-f3101b2555fa', '06c2f173-4fac-4520-8666-58c379171019', 1.2200, 3, 2100.00, '2023-12-28 19:27:26', null);
-- insert into bankapp.agreement (ag_id, ag_account_id, ag_product_id, ag_interest_rate, ag_status, ag_sum, ag_create_at, ag_update_at) values ('4a553542-8635-4932-9174-b2c95b13ba41', '602f0704-d25d-4e8b-b559-4ce7c555df93', '261241cb-f206-4b29-a779-6fe116538763', 1.0000, 4, 10000.00, '2023-12-28 19:29:34', null);
-- insert into bankapp.agreement (ag_id, ag_account_id, ag_product_id, ag_interest_rate, ag_status, ag_sum, ag_create_at, ag_update_at) values ('84c25db6-9567-4ce2-b3dd-9d15eda3ba8d', 'a5715090-d6f7-49e9-8b65-505284bf8ade', 'b94c7073-f7c7-454e-8ca7-0180e8f580d1', 1.2000, 0, 12002.00, '2023-12-28 19:31:12', null);
-- insert into bankapp.agreement (ag_id, ag_account_id, ag_product_id, ag_interest_rate, ag_status, ag_sum, ag_create_at, ag_update_at) values ('03c5b0de-81b9-45eb-b96f-a552793f4609', 'b3ce2779-8dbf-487f-b43e-b7af5c1dac97', '06c2f173-4fac-4520-8666-58c379171019', 1.2500, 2, 300.00, '2023-12-28 19:32:34', null);
-- insert into bankapp.agreement (ag_id, ag_account_id, ag_product_id, ag_interest_rate, ag_status, ag_sum, ag_create_at, ag_update_at) values ('beb33708-8d7f-4981-b2a5-dffc0f4896f4', 'b9f69f21-b390-4783-b5f1-3c700be89bc4', '261241cb-f206-4b29-a779-6fe116538763', 1.2000, 3, 1100.00, '2023-12-28 19:36:29', null);
-- insert into bankapp.agreement (ag_id, ag_account_id, ag_product_id, ag_interest_rate, ag_status, ag_sum, ag_create_at, ag_update_at) values ('1dff4564-f89c-45cf-9118-abe22c021aac', 'cad16388-2f41-448f-a991-aa75b13dd005', 'b94c7073-f7c7-454e-8ca7-0180e8f580d1', 1.2220, 4, 100.00, '2023-12-28 19:38:17', null);
-- insert into bankapp.agreement (ag_id, ag_account_id, ag_product_id, ag_interest_rate, ag_status, ag_sum, ag_create_at, ag_update_at) values ('88a771b4-a341-4acc-a78d-d13ee6adb5da', 'df2de6a0-1723-486a-a3e6-07d31e638df5', '06c2f173-4fac-4520-8666-58c379171019', 1.0000, 0, 1450.00, '2023-12-28 19:41:08', null);
-- insert into bankapp.agreement (ag_id, ag_account_id, ag_product_id, ag_interest_rate, ag_status, ag_sum, ag_create_at, ag_update_at) values ('1e443fdf-59c6-4a2e-8533-444867f542d8', '0c70afa1-c654-471d-9cb2-437ac289d62c', '261241cb-f206-4b29-a779-6fe116538763', 1.0000, 1, 1000.00, '2023-12-28 19:43:54', null);
-- insert into bankapp.agreement (ag_id, ag_account_id, ag_product_id, ag_interest_rate, ag_status, ag_sum, ag_create_at, ag_update_at) values ('beeb4671-fc55-4aab-91ab-8ca891bcbb73', '23a1d7a0-995f-44d2-b401-c56e1b2c6023', 'b94c7073-f7c7-454e-8ca7-0180e8f580d1', 1.2500, 2, 2222.00, '2023-12-28 19:45:28', null);
-- insert into bankapp.agreement (ag_id, ag_account_id, ag_product_id, ag_interest_rate, ag_status, ag_sum, ag_create_at, ag_update_at) values ('f6953ab9-7bdb-413b-b253-7e150790e8c4', '4864f038-580e-452e-a661-8a49f0e11cd9', '06c2f173-4fac-4520-8666-58c379171019', 1.0000, 0, 300.00, '2023-12-28 19:47:01', null);
-- insert into bankapp.agreement (ag_id, ag_account_id, ag_product_id, ag_interest_rate, ag_status, ag_sum, ag_create_at, ag_update_at) values ('50fc3cab-be14-42b9-95b6-f307ee47e044', '5bf54fcd-9a6c-4727-aac6-f3101b2555fa', '261241cb-f206-4b29-a779-6fe116538763', 1.0000, 3, 1000.00, '2023-12-28 19:48:31', null);
-- insert into bankapp.agreement (ag_id, ag_account_id, ag_product_id, ag_interest_rate, ag_status, ag_sum, ag_create_at, ag_update_at) values ('73df0c80-9a92-4a3b-8ce3-d06ab7554cbc', '602f0704-d25d-4e8b-b559-4ce7c555df93', 'b94c7073-f7c7-454e-8ca7-0180e8f580d1', 1.0000, 3, 200.00, '2023-12-28 19:51:05', null);
-- insert into bankapp.agreement (ag_id, ag_account_id, ag_product_id, ag_interest_rate, ag_status, ag_sum, ag_create_at, ag_update_at) values ('4028ae0b-a98c-4e6d-b92f-4455e01ccbbd', 'a5715090-d6f7-49e9-8b65-505284bf8ade', '06c2f173-4fac-4520-8666-58c379171019', 1.2000, 0, 1000.00, '2023-12-28 19:52:24', null);
-- insert into bankapp.agreement (ag_id, ag_account_id, ag_product_id, ag_interest_rate, ag_status, ag_sum, ag_create_at, ag_update_at) values ('3818328c-4d4f-48dd-92d2-3095dcb9bafa', 'b3ce2779-8dbf-487f-b43e-b7af5c1dac97', '261241cb-f206-4b29-a779-6fe116538763', 1.0000, 0, 500.00, '2023-12-28 19:54:11', null);
-- insert into bankapp.agreement (ag_id, ag_account_id, ag_product_id, ag_interest_rate, ag_status, ag_sum, ag_create_at, ag_update_at) values ('d52517d7-5f44-481d-bb0e-9befdd36270f', 'b9f69f21-b390-4783-b5f1-3c700be89bc4', 'b94c7073-f7c7-454e-8ca7-0180e8f580d1', 1.2500, 4, 1000.00, '2023-12-28 19:55:33', null);
-- insert into bankapp.agreement (ag_id, ag_account_id, ag_product_id, ag_interest_rate, ag_status, ag_sum, ag_create_at, ag_update_at) values ('aa0ec757-afcf-4a7d-a96a-41075f98221b', 'cad16388-2f41-448f-a991-aa75b13dd005', '06c2f173-4fac-4520-8666-58c379171019', 1.1000, 0, 2500.00, '2023-12-28 19:56:57', null);

insert into bankapp.transaction (t_debit_account_id, t_credit_account_id, t_type, t_amount, t_description)
SELECT
    a1.a_id AS t_debit_account_id,
    a2.a_id AS t_credit_account_id,
    2 AS t_type,
    500.0000 AS t_amount,
    'cash' AS t_description
FROM
    account a1, account a2
WHERE
    a1.a_id <> a2.a_id
ORDER BY RAND()
    LIMIT 1;

INSERT INTO bankapp.transaction (t_debit_account_id, t_credit_account_id, t_type, t_amount, t_description)
SELECT
    a1.a_id AS t_debit_account_id,
    a2.a_id AS t_credit_account_id,
    0 AS t_type,
    210.0000 AS t_amount,
    'perevod' AS t_description
FROM
    account a1, account a2
WHERE
    a1.a_id <> a2.a_id
ORDER BY RAND()
    LIMIT 1;

INSERT INTO bankapp.transaction (t_debit_account_id, t_credit_account_id, t_type, t_amount, t_description)
SELECT
    a1.a_id AS t_debit_account_id,
    a2.a_id AS t_credit_account_id,
    2 AS t_type,
    321.0000 AS t_amount,
    'cash' AS t_description
FROM
    account a1, account a2
WHERE
    a1.a_id <> a2.a_id
ORDER BY RAND()
    LIMIT 1;

INSERT INTO bankapp.transaction (t_debit_account_id, t_credit_account_id, t_type, t_amount, t_description)
SELECT
    a1.a_id AS t_debit_account_id,
    a2.a_id AS t_credit_account_id,
    2 AS t_type,
    2323.0000 AS t_amount,
    'my cash for you' AS t_description
FROM
    account a1, account a2
WHERE
    a1.a_id <> a2.a_id
ORDER BY RAND()
    LIMIT 1;

INSERT INTO bankapp.transaction (t_debit_account_id, t_credit_account_id, t_type, t_amount, t_description)
SELECT
    a1.a_id AS t_debit_account_id,
    a2.a_id AS t_credit_account_id,
    0 AS t_type,
    1000.0000 AS t_amount,
    'transfer' AS t_description
FROM
    account a1, account a2
WHERE
    a1.a_id <> a2.a_id
ORDER BY RAND()
    LIMIT 1;

INSERT INTO bankapp.transaction (t_debit_account_id, t_credit_account_id, t_type, t_amount, t_description)
SELECT
    a1.a_id AS t_debit_account_id,
    a2.a_id AS t_credit_account_id,
    3 AS t_type,
    22222.0000 AS t_amount,
    'deposit' AS t_description
FROM
    account a1, account a2
WHERE
    a1.a_id <> a2.a_id
ORDER BY RAND()
    LIMIT 1;

INSERT INTO bankapp.transaction (t_debit_account_id, t_credit_account_id, t_type, t_amount, t_description)
SELECT
    a1.a_id AS t_debit_account_id,
    a2.a_id AS t_credit_account_id,
    0 AS t_type,
    300.0000 AS t_amount,
    'transfer' AS t_description
FROM
    account a1, account a2
WHERE
    a1.a_id <> a2.a_id
ORDER BY RAND()
    LIMIT 1;

INSERT INTO bankapp.transaction (t_debit_account_id, t_credit_account_id, t_type, t_amount, t_description)
SELECT
    a1.a_id AS t_debit_account_id,
    a2.a_id AS t_credit_account_id,
    1 AS t_type,
    2211.0000 AS t_amount,
    'pay' AS t_description
FROM
    account a1, account a2
WHERE
    a1.a_id <> a2.a_id
ORDER BY RAND()
    LIMIT 1;

INSERT INTO bankapp.transaction (t_debit_account_id, t_credit_account_id, t_type, t_amount, t_description)
SELECT
    a1.a_id AS t_debit_account_id,
    a2.a_id AS t_credit_account_id,
    3 AS t_type,
    1000.0000 AS t_amount,
    'may deposit' AS t_description
FROM
    account a1, account a2
WHERE
    a1.a_id <> a2.a_id
ORDER BY RAND()
    LIMIT 1;

INSERT INTO bankapp.transaction (t_debit_account_id, t_credit_account_id, t_type, t_amount, t_description)
SELECT
    a1.a_id AS t_debit_account_id,
    a2.a_id AS t_credit_account_id,
    2 AS t_type,
    6676.0000 AS t_amount,
    'cash' AS t_description
FROM
    account a1, account a2
WHERE
    a1.a_id <> a2.a_id
ORDER BY RAND()
    LIMIT 1;

INSERT INTO bankapp.transaction (t_debit_account_id, t_credit_account_id, t_type, t_amount, t_description)
SELECT
    a1.a_id AS t_debit_account_id,
    a2.a_id AS t_credit_account_id,
    0 AS t_type,
    60960.0000 AS t_amount,
    'my transfer' AS t_description
FROM
    account a1, account a2
WHERE
    a1.a_id <> a2.a_id
ORDER BY RAND()
    LIMIT 1;

INSERT INTO bankapp.transaction (t_debit_account_id, t_credit_account_id, t_type, t_amount, t_description)
SELECT
    a1.a_id AS t_debit_account_id,
    a2.a_id AS t_credit_account_id,
    1 AS t_type,
    233.0000 AS t_amount,
    'pay' AS t_description
FROM
    account a1, account a2
WHERE
    a1.a_id <> a2.a_id
ORDER BY RAND()
    LIMIT 1;

INSERT INTO bankapp.transaction (t_debit_account_id, t_credit_account_id, t_type, t_amount, t_description)
SELECT
    a1.a_id AS t_debit_account_id,
    a2.a_id AS t_credit_account_id,
    1 AS t_type,
    1000.0000 AS t_amount,
    'pay za krasivie glazki' AS t_description
FROM
    account a1, account a2
WHERE
    a1.a_id <> a2.a_id
ORDER BY RAND()
    LIMIT 1;

INSERT INTO bankapp.transaction (t_debit_account_id, t_credit_account_id, t_type, t_amount, t_description)
SELECT
    a1.a_id AS t_debit_account_id,
    a2.a_id AS t_credit_account_id,
    2 AS t_type,
    100.0000 AS t_amount,
    'cash' AS t_description
FROM
    account a1, account a2
WHERE
    a1.a_id <> a2.a_id
ORDER BY RAND()
    LIMIT 1;

INSERT INTO bankapp.transaction (t_debit_account_id, t_credit_account_id, t_type, t_amount, t_description)
SELECT
    a1.a_id AS t_debit_account_id,
    a2.a_id AS t_credit_account_id,
    3 AS t_type,
    400.0000 AS t_amount,
    'deposit' AS t_description
FROM
    account a1, account a2
WHERE
    a1.a_id <> a2.a_id
ORDER BY RAND()
    LIMIT 1;

INSERT INTO bankapp.transaction (t_debit_account_id, t_credit_account_id, t_type, t_amount, t_description)
SELECT
    a1.a_id AS t_debit_account_id,
    a2.a_id AS t_credit_account_id,
    3 AS t_type,
    222.0000 AS t_amount,
    'deposit' AS t_description
FROM
    account a1, account a2
WHERE
    a1.a_id <> a2.a_id
ORDER BY RAND()
    LIMIT 1;

INSERT INTO bankapp.transaction (t_debit_account_id, t_credit_account_id, t_type, t_amount, t_description)
SELECT
    a1.a_id AS t_debit_account_id,
    a2.a_id AS t_credit_account_id,
    1 AS t_type,
    2000.0000 AS t_amount,
    'pay' AS t_description
FROM
    account a1, account a2
WHERE
    a1.a_id <> a2.a_id
ORDER BY RAND()
    LIMIT 1;

INSERT INTO bankapp.transaction (t_debit_account_id, t_credit_account_id, t_type, t_amount, t_description)
SELECT
    a1.a_id AS t_debit_account_id,
    a2.a_id AS t_credit_account_id,
    1 AS t_type,
    4045.0000 AS t_amount,
    'my pay' AS t_description
FROM
    account a1, account a2
WHERE
    a1.a_id <> a2.a_id
ORDER BY RAND()
    LIMIT 1;

INSERT INTO bankapp.transaction (t_debit_account_id, t_credit_account_id, t_type, t_amount, t_description)
SELECT
    a1.a_id AS t_debit_account_id,
    a2.a_id AS t_credit_account_id,
    0 AS t_type,
    10000.0000 AS t_amount,
    'transfer' AS t_description
FROM
    account a1, account a2
WHERE
    a1.a_id <> a2.a_id
ORDER BY RAND()
    LIMIT 1;
--
-- insert into bankapp.transaction (t_id, t_debit_account_id, t_credit_account_id, t_type, t_amount, t_description, t_create_at) values ('03c5b0de-81b9-45eb-b96f-a552793f4609', 'b9f69f21-b390-4783-b5f1-3c700be89bc4', 'cad16388-2f41-448f-a991-aa75b13dd005', 2, 500.0000, 'cash', '2023-12-28 20:39:29');
-- insert into bankapp.transaction (t_id, t_debit_account_id, t_credit_account_id, t_type, t_amount, t_description, t_create_at) values ('1dff4564-f89c-45cf-9118-abe22c021aac', 'df2de6a0-1723-486a-a3e6-07d31e638df5', '0c70afa1-c654-471d-9cb2-437ac289d62c', 0, 210.0000, 'perevod ', '2023-12-28 20:49:54');
-- insert into bankapp.transaction (t_id, t_debit_account_id, t_credit_account_id, t_type, t_amount, t_description, t_create_at) values ('1e443fdf-59c6-4a2e-8533-444867f542d8', 'df2de6a0-1723-486a-a3e6-07d31e638df5', 'cad16388-2f41-448f-a991-aa75b13dd005', 2, 321.0000, 'cash ', '2023-12-28 20:55:42');
-- insert into bankapp.transaction (t_id, t_debit_account_id, t_credit_account_id, t_type, t_amount, t_description, t_create_at) values ('21772977-4026-47ca-b124-523a489307ee', '4864f038-580e-452e-a661-8a49f0e11cd9', '5bf54fcd-9a6c-4727-aac6-f3101b2555fa', 2, 2323.0000, 'my cash for you', '2023-12-28 20:34:56');
-- insert into bankapp.transaction (t_id, t_debit_account_id, t_credit_account_id, t_type, t_amount, t_description, t_create_at) values ('3818328c-4d4f-48dd-92d2-3095dcb9bafa', '5bf54fcd-9a6c-4727-aac6-f3101b2555fa', '4864f038-580e-452e-a661-8a49f0e11cd9', 0, 1000.0000, 'transfer', '2023-12-28 21:05:16');
-- insert into bankapp.transaction (t_id, t_debit_account_id, t_credit_account_id, t_type, t_amount, t_description, t_create_at) values ('4028ae0b-a98c-4e6d-b92f-4455e01ccbbd', '602f0704-d25d-4e8b-b559-4ce7c555df93', '5bf54fcd-9a6c-4727-aac6-f3101b2555fa', 3, 22222.0000, 'deposit', '2023-12-28 21:04:01');
-- insert into bankapp.transaction (t_id, t_debit_account_id, t_credit_account_id, t_type, t_amount, t_description, t_create_at) values ('4a553542-8635-4932-9174-b2c95b13ba41', '602f0704-d25d-4e8b-b559-4ce7c555df93', 'a5715090-d6f7-49e9-8b65-505284bf8ade', 0, 300.0000, 'transfer', '2023-12-28 20:36:35');
-- insert into bankapp.transaction (t_id, t_debit_account_id, t_credit_account_id, t_type, t_amount, t_description, t_create_at) values ('50fc3cab-be14-42b9-95b6-f307ee47e044', 'b3ce2779-8dbf-487f-b43e-b7af5c1dac97', 'a5715090-d6f7-49e9-8b65-505284bf8ade', 1, 2211.0000, 'pay', '2023-12-28 21:01:18');
-- insert into bankapp.transaction (t_id, t_debit_account_id, t_credit_account_id, t_type, t_amount, t_description, t_create_at) values ('556330ef-b019-4744-923e-cffe7c7e5cd4', '5bf54fcd-9a6c-4727-aac6-f3101b2555fa', '602f0704-d25d-4e8b-b559-4ce7c555df93', 3, 1000.0000, 'may deposit', '2023-12-28 20:34:59');
-- insert into bankapp.transaction (t_id, t_debit_account_id, t_credit_account_id, t_type, t_amount, t_description, t_create_at) values ('73df0c80-9a92-4a3b-8ce3-d06ab7554cbc', 'a5715090-d6f7-49e9-8b65-505284bf8ade', '602f0704-d25d-4e8b-b559-4ce7c555df93', 2, 6676.0000, 'cash', '2023-12-28 21:02:27');
-- insert into bankapp.transaction (t_id, t_debit_account_id, t_credit_account_id, t_type, t_amount, t_description, t_create_at) values ('7bf29834-a48b-4e2a-b023-d99e35f3e3b8', '0c70afa1-c654-471d-9cb2-437ac289d62c', '23a1d7a0-995f-44d2-b401-c56e1b2c6023', 0, 60960.0000, 'my transfer', '2023-12-28 20:21:37');
-- insert into bankapp.transaction (t_id, t_debit_account_id, t_credit_account_id, t_type, t_amount, t_description, t_create_at) values ('84c25db6-9567-4ce2-b3dd-9d15eda3ba8d', 'a5715090-d6f7-49e9-8b65-505284bf8ade', 'b3ce2779-8dbf-487f-b43e-b7af5c1dac97', 1, 233.0000, 'pay', '2023-12-28 20:38:07');
-- insert into bankapp.transaction (t_id, t_debit_account_id, t_credit_account_id, t_type, t_amount, t_description, t_create_at) values ('88a771b4-a341-4acc-a78d-d13ee6adb5da', '0c70afa1-c654-471d-9cb2-437ac289d62c', 'df2de6a0-1723-486a-a3e6-07d31e638df5', 1, 1000.0000, 'pay za krasivie glazki', '2023-12-28 20:52:39');
-- insert into bankapp.transaction (t_id, t_debit_account_id, t_credit_account_id, t_type, t_amount, t_description, t_create_at) values ('aa0ec757-afcf-4a7d-a96a-41075f98221b', '23a1d7a0-995f-44d2-b401-c56e1b2c6023', '0c70afa1-c654-471d-9cb2-437ac289d62c', 2, 100.0000, 'cash', '2023-12-28 21:07:42');
-- insert into bankapp.transaction (t_id, t_debit_account_id, t_credit_account_id, t_type, t_amount, t_description, t_create_at) values ('beb33708-8d7f-4981-b2a5-dffc0f4896f4', 'cad16388-2f41-448f-a991-aa75b13dd005', 'df2de6a0-1723-486a-a3e6-07d31e638df5', 3, 400.0000, 'deposit', '2023-12-28 20:47:23');
-- insert into bankapp.transaction (t_id, t_debit_account_id, t_credit_account_id, t_type, t_amount, t_description, t_create_at) values ('beeb4671-fc55-4aab-91ab-8ca891bcbb73', 'cad16388-2f41-448f-a991-aa75b13dd005', 'b9f69f21-b390-4783-b5f1-3c700be89bc4', 3, 222.0000, 'deposit', '2023-12-28 20:57:07');
-- insert into bankapp.transaction (t_id, t_debit_account_id, t_credit_account_id, t_type, t_amount, t_description, t_create_at) values ('d52517d7-5f44-481d-bb0e-9befdd36270f', '4864f038-580e-452e-a661-8a49f0e11cd9', '23a1d7a0-995f-44d2-b401-c56e1b2c6023', 1, 2000.0000, 'pay', '2023-12-28 21:06:21');
-- insert into bankapp.transaction (t_id, t_debit_account_id, t_credit_account_id, t_type, t_amount, t_description, t_create_at) values ('d965c068-4d54-4382-ac62-7f2db627dc6c', '23a1d7a0-995f-44d2-b401-c56e1b2c6023', '4864f038-580e-452e-a661-8a49f0e11cd9', 1, 4045.0000, 'my pay', '2023-12-28 20:31:08');
-- insert into bankapp.transaction (t_id, t_debit_account_id, t_credit_account_id, t_type, t_amount, t_description, t_create_at) values ('f6953ab9-7bdb-413b-b253-7e150790e8c4', 'b9f69f21-b390-4783-b5f1-3c700be89bc4', 'b3ce2779-8dbf-487f-b43e-b7af5c1dac97', 0, 10000.0000, 'transfer', '2023-12-28 20:59:09');

-- Вставляем возможные значения ролей
INSERT INTO bankapp.roles (r_id, r_role_name) VALUES (2, 'ROLE_USER');
INSERT INTO bankapp.roles (r_id, r_role_name) VALUES (1, 'ROLE_ADMIN');

INSERT INTO users (u_id, u_username, u_password, u_email, u_role)
VALUES (1, 'Dima', '111', 'example@example.com', 'ROLE_ADMIN');
