-- create-manager-table
create table IF NOT EXISTS manager
(
    m_id         binary(16) primary key NOT NULL,
    m_first_name varchar(50),
    m_last_name  varchar(50),
    m_status     tinyint,
    m_password   varchar(100),
    m_create_at  timestamp              NOT NULL DEFAULT CURRENT_TIMESTAMP,
    m_update_at  timestamp
);

-- create-product-table
create table IF NOT EXISTS product
(
    p_id            binary(16) primary key NOT NULL,
    p_manager_id    binary(16),
    p_name          varchar(70),
    p_status        tinyint,
    p_currency_code int,
    p_interest_rate decimal(6, 4),
    p_limit_        int,
    p_create_at     timestamp              NOT NULL DEFAULT CURRENT_TIMESTAMP,
    p_update_at     timestamp,
    constraint fk_product_manager
        foreign key (p_manager_id) references manager (m_id)
);

-- create-client-table
create table IF NOT EXISTS client
(
    c_id         binary(16) primary key NOT NULL,
    c_manager_id binary(16),
    c_status     tinyint,
    c_tax_code   varchar(20),
    c_first_name varchar(50),
    c_last_name  varchar(50),
    c_email      varchar(60),
    c_address    varchar(80),
    c_phone      varchar(20),
    c_create_at  timestamp              NOT NULL DEFAULT CURRENT_TIMESTAMP,
    c_update_at  timestamp,
    constraint fk_client_manager
        foreign key (c_manager_id) references manager (m_id)
);

-- create-account-table
create table IF NOT EXISTS account
(
    a_id             binary(16) primary key NOT NULL,
    a_client_id      binary(16),
    a_account_number varchar(100),
    a_type           int,
    a_status         tinyint,
    a_balance        decimal(15, 2),
    a_currency_code  int,
    a_create_at      timestamp              NOT NULL DEFAULT CURRENT_TIMESTAMP,
    a_update_at      timestamp,
    constraint fk_account_client_id
        foreign key (a_client_id) references client (c_id)
);

-- create-transaction-table
create table IF NOT EXISTS transaction
(
    t_id                binary(16) primary key NOT NULL,
    t_debit_account_id  binary(16),
    t_credit_account_id binary(16),
    t_type              int,
    t_amount            decimal(12, 4),
    t_description       varchar(255),
    t_create_at         timestamp              NOT NULL DEFAULT CURRENT_TIMESTAMP,
    constraint fk_transaction_credit_account
        foreign key (t_credit_account_id) references account (a_id),
    constraint fk_transaction_debit_account
        foreign key (t_debit_account_id) references account (a_id)
);

-- create-agreement-table
create table IF NOT EXISTS agreement
(
    ag_id            binary(16) primary key NOT NULL,
    ag_account_id    binary(16),
    ag_product_id    binary(16),
    ag_interest_rate decimal(6, 4),
    ag_status        tinyint,
    ag_sum           decimal(15, 2),
    ag_create_at     timestamp              NOT NULL DEFAULT CURRENT_TIMESTAMP,
    ag_update_at     timestamp,
    constraint fk_agreement_account
        foreign key (ag_account_id) references account (a_id),
    constraint fk_agreement_product
        foreign key (ag_product_id) references product (p_id)
);
