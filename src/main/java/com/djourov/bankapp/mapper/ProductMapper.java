package com.djourov.bankapp.mapper;

import com.djourov.bankapp.dto.ProductDto;
import com.djourov.bankapp.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.sql.Date;


@Mapper(componentModel = "spring", imports = {Date.class})
public interface ProductMapper {
    @Mapping(defaultValue = "ACTIVE", target = "product.status")
    @Mapping(defaultValue = "EUR", target = "product.currencyCode")
    @Mapping(defaultValue = "2.25", target = "product.interestRate")
    @Mapping(expression = "java(new Date(System.currentTimeMillis()))", target = "product.createdAt")
    @Mapping(target = "product.limit", qualifiedByName = "toUpperCase")
    Product toEntity(ProductDto productDto);

    @Named("toUpperCase")
    default String toUpperCase(String limit) {
        return limit.toUpperCase();
    }
}
