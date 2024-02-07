package com.djourov.bankapp.mapper;

import com.djourov.bankapp.dto.ProductDto;
import com.djourov.bankapp.entity.Product;
import com.djourov.bankapp.service.interf.ManagerService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.UUID;

@Mapper(componentModel = "spring", imports = {Date.class})

public abstract class ProductMapper {
    @Autowired
    protected ManagerService managerService;

    @Mappings({
            @Mapping(target = "status", qualifiedByName = "statusParseString", source = "status"),
            @Mapping(target = "currencyCode", qualifiedByName = "currencyCodeParseString", source = "currencyCode"),
            @Mapping(target = "interestRate", qualifiedByName = "parseBigDecimal", source = "interestRate"),
            @Mapping(expression = "java(currentDate())", target = "createdAt"),
            @Mapping(target = "limit", qualifiedByName = "parseInt", source = "limit"),
            @Mapping(target = "manager", expression = "java(managerService.getManagerReferenceById(fromString(productDto.getManagerId())))")
    })
    public abstract Product toEntity(ProductDto productDto);

    @Named("statusParseString")
    public static String statusParseString(String status) {
        return String.valueOf(status);
    }

    @Named("currencyCodeParseString")
    public static String currencyCodeParseString(String currencyCode) {
        return String.valueOf(currencyCode);
    }

    @Named("parseInt")
    public static int parseInt(String limit) {
        return Integer.parseInt(limit);
    }

    @Named("parseBigDecimal")
    public static BigDecimal parseBigDecimal(String interestRate) {
        return new BigDecimal(interestRate);
    }

    @Named("currentDate")
    public static LocalDate currentDate() {
        return LocalDate.now();
    }

    protected UUID fromString(String id) {
        return UUID.fromString(id);
    }

}
