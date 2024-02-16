package com.djourov.bankapp.util;

import com.djourov.bankapp.entity.*;
import com.djourov.bankapp.entity.enums.*;
import lombok.experimental.UtilityClass;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.UUID;

@UtilityClass
public class EntityCreator {
    public static Account getAccount() {
        Account account = new Account();
        account.setId(UUID.fromString("66664999-3333-1111-a456-426655440000"));
        account.setAccountNumber("123456999");
        account.setType(AccountTypeStatus.BUSINESS_ACCOUNT);
        account.setStatus(AccountStatus.ACTIVE);
        account.setBalance(new BigDecimal("2222.00"));
        account.setCurrencyCode(AccountCurrencyCode.EUR);
        account.setCreatedAt(LocalDate.of(2024, Month.FEBRUARY, 11));
        account.setUpdatedAt(LocalDate.of(2024, Month.FEBRUARY, 12));
        return account;
    }

    public static Agreement getAgreement() {
        Agreement agreement = new Agreement();
        agreement.setId(UUID.fromString("1b1646d8-c45d-11ee-bf28-00155d558766"));
        agreement.setInterestRate(new BigDecimal("1.2500"));
        agreement.setStatus(AgreementStatus.ACTIVE);
        agreement.setSum(new BigDecimal("1000.00"));
        agreement.setCreatedAt(LocalDate.of(2024, Month.FEBRUARY, 11));
        agreement.setUpdatedAt(LocalDate.of(2024, Month.FEBRUARY, 12));
        return agreement;
    }

    public static Client getClient() {
        Client client = new Client();
        client.setId(UUID.fromString("1b117ebe-c45d-11ee-bf28-00155d558766"));
        client.setStatus(ClientStatus.ACTIVE);
        client.setTaxCode("5453243666");
        client.setFirstName("Li");
        client.setLastName("Po");
        client.setEmail("Li.Po@gmail.com");
        client.setAddress("Piter, Moyka 12/20");
        client.setPhone("+095 777 777 77");
        client.setCreatedAt(LocalDate.of(2024, Month.FEBRUARY, 11));
        client.setUpdatedAt(LocalDate.of(2024, Month.FEBRUARY, 12));
        return client;
    }

    public static Manager getManager() {
        Manager manager = new Manager();
        manager.setId(UUID.fromString("1b0f92f6-c45d-11ee-bf28-00155d558777"));
        manager.setFirstName("Coco");
        manager.setLastName("Chanel");
        manager.setStatus(ManagerStatus.SENIOR_MANAGER);
        manager.setCreatedAt(LocalDate.of(2024, Month.FEBRUARY, 11));
        manager.setUpdatedAt(LocalDate.of(2024, Month.FEBRUARY, 12));
        return manager;
    }

    public static Product getProduct() {
        Product product = new Product();
        product.setId(UUID.fromString("1b109afa-c45d-11ee-bf28-00155d55888"));
        product.setName(ProductName.DEBIT_CARD);
        product.setStatus(ProductStatus.ACTIVE);
        product.setCurrencyCode(AccountCurrencyCode.EUR);
        product.setInterestRate(new BigDecimal("2.2500"));
        product.setLimit(1000);
        product.setCreatedAt(LocalDate.of(2024, Month.FEBRUARY, 11));
        product.setUpdatedAt(LocalDate.of(2024, Month.FEBRUARY, 12));
        return product;
    }

    public static Transaction transaction() {
        Transaction transaction = new Transaction();
        transaction.setId(UUID.fromString("1b1a91cf-c45d-11ee-bf28-00155d558666"));
        transaction.setType(TransactionTypeStatus.CASH);
        transaction.setAmount(new BigDecimal("500.0000"));
        transaction.setDescription("Happy Birthday!");
        transaction.setCreateAt(LocalDate.of(2024, Month.FEBRUARY, 11));
        return transaction;
    }
}
