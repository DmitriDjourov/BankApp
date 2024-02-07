package com.djourov.bankapp.mapper;

import com.djourov.bankapp.dto.ClientActiveDto;
import com.djourov.bankapp.entity.Client;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")

public interface ClientActiveMapper {
    ClientActiveDto toDto(Client client);

    List<ClientActiveDto> toDtoList(List<Client> clientByStatus);
}





