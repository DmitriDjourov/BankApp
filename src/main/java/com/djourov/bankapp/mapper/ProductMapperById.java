package com.djourov.bankapp.mapper;


import com.djourov.bankapp.dto.ProductDto;
import com.djourov.bankapp.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapperById {
   ProductDto toDto(Product referenceById);
}
