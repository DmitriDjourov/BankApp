package com.djourov.bankapp.mapper;

import com.djourov.bankapp.dto.ClientDto;
import com.djourov.bankapp.entity.Client;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    ClientDto toDto(Client referenceById);
}
