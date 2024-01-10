-- liquibase formatted sql

-- changeset DmitriDjourov:createTriggers
CREATE TRIGGER before_insert_manager
    BEFORE INSERT ON bankapp.manager
    FOR EACH ROW
    SET NEW.m_id = IFNULL(NEW.m_id, UUID_TO_BIN(UUID())),
        NEW.m_create_at = IFNULL(NEW.m_create_at, LOCALTIME);

CREATE TRIGGER before_insert_product
    BEFORE INSERT ON bankapp.product
    FOR EACH ROW
    SET NEW.p_id = IFNULL(NEW.p_id, UUID_TO_BIN(UUID())),
        NEW.p_create_at = IFNULL(NEW.p_create_at, LOCALTIME);

CREATE TRIGGER before_insert_client
    BEFORE INSERT ON bankapp.client
    FOR EACH ROW
    SET NEW.c_id = IFNULL(NEW.c_id, UUID_TO_BIN(UUID()));

CREATE TRIGGER before_insert_account
    BEFORE INSERT ON bankapp.account
    FOR EACH ROW
    SET NEW.a_id = IFNULL(NEW.a_id, UUID_TO_BIN(UUID()));

CREATE TRIGGER before_insert_transaction
    BEFORE INSERT ON bankapp.transaction
    FOR EACH ROW
    SET NEW.t_id = IFNULL(NEW.t_id, UUID_TO_BIN(UUID()));

CREATE TRIGGER before_insert_agreement
    BEFORE INSERT ON bankapp.agreement
    FOR EACH ROW
    SET NEW.ag_id = IFNULL(NEW.ag_id, UUID_TO_BIN(UUID()));

