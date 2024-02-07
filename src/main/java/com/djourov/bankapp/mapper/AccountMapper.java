package com.djourov.bankapp.mapper;

import com.djourov.bankapp.dto.AccountDto;
import com.djourov.bankapp.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface AccountMapper {
    @Mapping(source = "client.firstName", target = "firstName")
    @Mapping(source = "client.lastName", target = "lastName")
    @Mapping(source = "client.manager.status", target = "status")
    AccountDto toDto(Account account);


//    @Mapping(target = "createdAt" , dateFormat = "dd-mm-yyyy")
//    @Mapping(target = "status" , constant = "INACTIVE")
//    @Mapping(target = "status" , defaultValue = "manager")
//    @Mapping(target = "createdAt" , expression = "java(new LocalDate(System.currentTimeMillis()))")
//    @Mapping(target = "createdAt" ,qualifiedByName = "method")
//    AccountDto toDtoEx(Account account);
//
//    @Named("method")
//    default String toLC(ManagerStatus status){
//        return "@@@@@";
//    }
}
