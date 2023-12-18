# Bank Project [Backend]

 There is a prototype of the BackEnd Bank's Core Services data.

 Data consist of clients, accounts, products, accounts, transactions and managers
___

* [ApiDoc Link](http://localhost:8080/swagger-ui/index.html) 
* [JACOCO Link](http://localhost:63342/BankWebApp/target/site/jacoco/index.html?_ijt=fthj7nhoeqb244etd5lb9cba13&_ij_reload=RELOAD_ON_SAVE)
___
## Database structure

### Table Client ( Bank's Clients table )

| Column name | Type        | Description                                                  |
|-------------|-------------|--------------------------------------------------------------|
| a_id        | binary(16)  | id key of row - unique, not null, primary key                |
| a_manager_id| binary(16)  | manager id foreign key not null                              |
| a_status    | tinyint(1)  | client's status     not null    DEFAULT '1'                  |
| a_tax_code  | varchar(20) | client's TAX code (external ID)                              |
| a_first_name| varchar(50) | client's name                                                |
| a_last_name | varchar(50) | client's surname                                             |
| a_email     | varchar(60) | client's e-mail                                              |
| a_address   | varchar(80) | client's address                                             |
| a_phone     | varchar(20) | client's phone                                               |
| a_created_at| timestamp   | timestamp of row creation,not null,DEFAULT CURRENT_TIMESTAMP |
| a_updated_at| timestamp   | timestamp of last update                                     |



### Table Account (Bank's accounts table)

| Column name      | Type          | Description                                                  |
|------------------|---------------|--------------------------------------------------------------|
| a_id             | binary(16)    | id key of row - unique, not null, primary key                |
| a_client_id      | binary(16)    | client id   foreign key  not null                            |         
| a_account_number | varchar(100)  | a name of account                                            |                              
| a_type           | int(1)        | account type                                                 |                                   
| a_status         | tinyint(1)    | status of tne account                                        |                          
| a_balance        | numeric(15,2) | balance of the account in currency                           | 
| a_currency_code  | int(2)        | account currency code                                        |                          
| a_created_at     | timestamp     | timestamp of row creation,not null,DEFAULT CURRENT_TIMESTAMP |
| a_updated_at     | timestamp     | timestamp of last update                                     |

### Table Product ( Sets of Bank's available Products)
| Column name     | Type          | Description                                                              |
|-----------------|---------------|--------------------------------------------------------------------------|
| p_id            | binary(16)    | id key of row - unique, not null, primary key                            |
| p_manager_id    | binary(16)    | manager id   foreign key   not null                                      |
| p_name          | varchar(70)   | product's name                                                           |
| p_status        | tinyint(1)    | product's status         not null                                        |
| p_currency_code | int(2)        | currency of product                                                      |
| p_interest_rate | numeric(6,4)  | interest rate of product                                                 |
| p_limit         | numeric(15,2) | limit of credit a product ( 0 - no limit, 0 < - limit which can be used) |
| p_created_at    | timestamp     | timestamp of row creation,not null,DEFAULT CURRENT_TIMESTAMP             |
| p_updated_at    | timestamp     | timestamp of last update                                                 |

### Table Agreement (Bank's - Client's  Agreement table)

| Column name       | Type          | Description                                                  |
|-------------------|---------------|--------------------------------------------------------------|
| ag_id             | binary(16)    | id key of row - unique, not null, primary key                |
| ag_account_id     | binary(16)    | client's account  foreign key not null                       | 
| ag_product_id     | binary(16)    | product id (table product) foreign key not null              | 
| ag_interest_rate  | numeric(6,4)	 | current interest rate of agreement                           | 
| ag_status         | tinyint(1)    | agreement's status,not null,DEFAULT '1'                      | 
| ag_sum            | numeric(15,2) | amount of agreement,not null,DEFAULT '0.00'                  | 
| ag_created_at     | timestamp     | timestamp of row creation,not null,DEFAULT CURRENT_TIMESTAMP | 
| ag_updated_at     | timestamp     | timestamp of last update                                     | 

 ### Table Transaction (Bank's Product table) 

| Column name          | Type          | Description                                                          |
|----------------------|---------------|----------------------------------------------------------------------|
| 	t_id                | binary(16)    | id key of row - unique, not null, primary key                        | 
| 	t_debit_account_id  | binary(16)    | transaction's debit account foreign key not null                     | 
| 	t_credit_account_id | binary(16)    | transaction's credit account foreign key not null                    | 
| 	t_type              | int(1)        | transaction type                                                     | 
| 	t_amount            | numeric(12,2) | transaction amount in the account currency, not null, DEFAULT '0.00' | 
| 	t_description       | varchar(255)  | description of transaction                                           | 
| 	t_created_at        | timestamp     | timestamp of row creation,not null,DEFAULT CURRENT_TIMESTAMP         | 

 ### Table Manager (Bank's managers )

| Column name    | Type         | Description                                                  |
|----------------|--------------|--------------------------------------------------------------|
| 	m_id          | binary(16)   | id key of row - unique, not null, primary key                | 
| 	m_first_name  | varchar(50)  | manager's name                                               | 
| 	m_last_name   | varchar(50)  | manager's surname                                            | 
| 	m_status      | tinyint(1)   | manager's status,not null,DEFAULT '1'                        | 
| 	m_description | varchar(255) | description of transaction                                   | 
| 	m_created_at  | timestamp    | timestamp of row creation,not null,DEFAULT CURRENT_TIMESTAMP |
| m_updated_at   | timestamp    | timestamp of last update                                     | 