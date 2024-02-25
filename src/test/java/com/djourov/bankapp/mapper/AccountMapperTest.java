package com.djourov.bankapp.mapper;

import com.djourov.bankapp.dto.AccountDto;
import com.djourov.bankapp.entity.Account;
import com.djourov.bankapp.entity.Client;
import com.djourov.bankapp.entity.Manager;
import com.djourov.bankapp.entity.enums.ManagerStatus;
import com.djourov.bankapp.util.EntityCreator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AccountMapperTest {

    private final AccountMapper accountMapper = new AccountMapperImpl();

    @Test
    void toDtoMapperTest() {
        Account account = EntityCreator.getAccount();
        Client client = EntityCreator.getClient();
        Manager manager = EntityCreator.getManager();
        client.setFirstName("John");
        client.setLastName("Doe");
        client.setManager(manager);
        account.setClient(client);
        AccountDto accountDto = accountMapper.toDto(account);
        Assertions.assertNotNull(accountDto);
        Assertions.assertEquals(account.getId().toString(), accountDto.getId());
        Assertions.assertEquals(account.getAccountNumber(), accountDto.getAccountNumber());
        Assertions.assertEquals("John", accountDto.getFirstName());
        Assertions.assertEquals("Doe", accountDto.getLastName());
        Assertions.assertEquals(ManagerStatus.SENIOR_MANAGER, accountDto.getStatus());
    }
}