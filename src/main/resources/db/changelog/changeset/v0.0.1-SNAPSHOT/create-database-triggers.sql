-- liquibase formatted sql

-- changeset DmitriDjourov:createTriggers
-- manager
CREATE TRIGGER IF NOT EXISTS before_insert_manager
    BEFORE INSERT ON bankapp.manager
    FOR EACH ROW
    SET NEW.m_id = IFNULL(NEW.m_id, UUID_TO_BIN(UUID()));

CREATE TRIGGER IF NOT EXISTS before_update_manager
    BEFORE UPDATE ON bankapp.manager
    FOR EACH ROW
    SET NEW.m_update_at = CURRENT_TIMESTAMP;

-- product
CREATE TRIGGER IF NOT EXISTS before_insert_product
    BEFORE INSERT ON bankapp.product
    FOR EACH ROW
    SET NEW.p_id = IFNULL(NEW.p_id, UUID_TO_BIN(UUID()));

CREATE TRIGGER IF NOT EXISTS before_update_product
    BEFORE UPDATE ON bankapp.product
    FOR EACH ROW
    SET NEW.p_update_at = CURRENT_TIMESTAMP;

-- client
CREATE TRIGGER IF NOT EXISTS before_insert_client
    BEFORE INSERT ON bankapp.client
    FOR EACH ROW
    SET NEW.c_id = IFNULL(NEW.c_id, UUID_TO_BIN(UUID()));

CREATE TRIGGER IF NOT EXISTS before_update_client
    BEFORE UPDATE ON bankapp.client
    FOR EACH ROW
    SET NEW.c_update_at = CURRENT_TIMESTAMP;

-- account
CREATE TRIGGER IF NOT EXISTS before_insert_account
    BEFORE INSERT ON bankapp.account
    FOR EACH ROW
    SET NEW.a_id = IFNULL(NEW.a_id, UUID_TO_BIN(UUID()));

CREATE TRIGGER IF NOT EXISTS before_update_account
    BEFORE UPDATE ON bankapp.account
    FOR EACH ROW
    SET NEW.a_update_at = CURRENT_TIMESTAMP;

-- transaction
CREATE TRIGGER IF NOT EXISTS before_insert_transaction
    BEFORE INSERT ON bankapp.transaction
    FOR EACH ROW
    SET NEW.t_id = IFNULL(NEW.t_id, UUID_TO_BIN(UUID()));

-- agreement
CREATE TRIGGER IF NOT EXISTS before_insert_agreement
    BEFORE INSERT ON bankapp.agreement
    FOR EACH ROW
    SET NEW.ag_id = IFNULL(NEW.ag_id, UUID_TO_BIN(UUID()));

CREATE TRIGGER IF NOT EXISTS before_update_agreement
    BEFORE UPDATE ON bankapp.agreement
    FOR EACH ROW
    SET NEW.ag_update_at = CURRENT_TIMESTAMP;