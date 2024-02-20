package com.djourov.bankapp.util;

import com.djourov.bankapp.dto.*;
import com.djourov.bankapp.entity.Client;
import com.djourov.bankapp.entity.enums.AccountCurrencyCode;
import com.djourov.bankapp.entity.enums.ClientStatus;
import com.djourov.bankapp.entity.enums.ManagerStatus;
import com.djourov.bankapp.entity.enums.ProductStatus;
import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@UtilityClass
public class DtoCreator {
    public static final String EXAMPLE_UUID = "11111111-1111-1111-1111-1111111111dc";

    public static AccountDto getAccountDto() {
        return new AccountDto(
                "91384699-c928-11ee-87e5-00155d26ef58",
                "123456789",
                "Anna",
                "Smirnova",
                ManagerStatus.CREDIT_MANAGER
        );
    }

    public static ClientActiveDto getClientActiveDto() {
        return ClientActiveDto.builder()
                       .firstName("Kon")
                       .lastName("Pedalniy")
                       .phone("095-987-9898")
                       .status(ClientStatus.ACTIVE.toString())
                       .build();
    }

    public static ClientDto getClientDto() {
        return ClientDto.builder()
                       .firstName("Kon")
                       .lastName("Pedalniy")
                       .firstNameManager("Vasiliy")
                       .lastNameManager("Pupkin")
                       .status(ManagerStatus.CREDIT_MANAGER)
                       .build();
    }

    public static ManagerDTO getManagerDTO() {
        return ManagerDTO.builder()
                       .firstName("Vasiliy")
                       .lastName("Pupkin")
                       .status(ManagerStatus.CREDIT_MANAGER)
                       .createdAt(LocalDate.now())
                       .clients(createClientList())
                       .build();
    }

    private static List<Client> createClientList() {
        List<Client> clients = new ArrayList<>();

        Client client1 = new Client();
        client1.setId(UUID.randomUUID());
        client1.setStatus(ClientStatus.ACTIVE);
        client1.setTaxCode("1234567890");
        client1.setFirstName("Alice");
        client1.setLastName("Smith");
        client1.setEmail("alice@example.com");
        client1.setAddress("123 Main St");
        client1.setPhone("123-456-7890");
        client1.setCreatedAt(LocalDate.now());
        // client1.setManager(manager);
        // client1.setAccounts(accounts);

        Client client2 = new Client();
        client2.setId(UUID.randomUUID());
        client2.setStatus(ClientStatus.ACTIVE);
        client2.setTaxCode("0987654321");
        client2.setFirstName("Bob");
        client2.setLastName("Jones");
        client2.setEmail("bob@example.com");
        client2.setAddress("456 Elm St");
        client2.setPhone("456-789-0123");
        client2.setCreatedAt(LocalDate.now());
        // client2.setManager(manager);
        // client2.setAccounts(accounts);

        clients.add(client1);
        clients.add(client2);

        return clients;
    }

    public static ProductDto getPeodustDto() {
        return ProductDto.builder()
                       .name("DEBIT_CARD")
                       .managerId("9130963b-c928-11ee-87e5-00155d26ef58")
                       .limit("1000")
                       .interestRate("2.2500")
                       .status(AccountCurrencyCode.ILS.toString())
                       .status(ProductStatus.ACTIVE.toString())
                       .build();
    }
}
