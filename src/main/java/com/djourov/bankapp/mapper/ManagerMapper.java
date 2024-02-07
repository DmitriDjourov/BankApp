package com.djourov.bankapp.mapper;

import com.djourov.bankapp.dto.ManagerDTO;
import com.djourov.bankapp.entity.Manager;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ManagerMapper {
    ManagerDTO toDto(Manager getManagerByIdFirstLastName);
}
