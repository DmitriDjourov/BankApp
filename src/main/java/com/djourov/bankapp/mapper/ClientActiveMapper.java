package com.djourov.bankapp.mapper;

import com.djourov.bankapp.dto.ClientActiveDto;
import com.djourov.bankapp.entity.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
//@Component
public interface ClientActiveMapper {
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "phone", target = "phone")
    @Mapping(source = "status", target = "status")
    ClientActiveDto toDto(Client client);

    List<ClientActiveDto> toDtoList(List<Client> clients);
}





