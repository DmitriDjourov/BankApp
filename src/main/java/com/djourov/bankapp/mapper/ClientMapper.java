package com.djourov.bankapp.mapper;

import com.djourov.bankapp.dto.ClientDto;
import com.djourov.bankapp.entity.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    @Mapping(source = "manager.firstName", target = "firstNameManager")
    @Mapping(source = "manager.lastName", target = "lastNameManager")
    @Mapping(source = "manager.status", target = "status")
    ClientDto toDto(Client referenceById);
}
