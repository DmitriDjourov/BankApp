package com.djourov.bankapp.mapper;

import com.djourov.bankapp.dto.ProductDto;
import com.djourov.bankapp.entity.Manager;
import com.djourov.bankapp.entity.Product;
import com.djourov.bankapp.service.interf.ManagerService;
import com.djourov.bankapp.util.DtoCreator;
import com.djourov.bankapp.util.EntityCreator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductMapperTest {
    @Mock
    private ManagerService managerService;
    @InjectMocks
    private ProductMapperImpl productMapper;

    @Test
    void toEntity() {
        ProductDto productDto = DtoCreator.getProductDto();
        Manager manager = EntityCreator.getManager();
        when(managerService.getManagerReferenceById(UUID.fromString(productDto.getManagerId()))).thenReturn(manager);
        Product result = productMapper.toEntity(productDto);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(productDto.getName(), result.getName().toString());
        Assertions.assertEquals(Integer.parseInt(productDto.getLimit()), result.getLimit());
        Assertions.assertEquals(productDto.getInterestRate(), result.getInterestRate().toString());
        Assertions.assertEquals(productDto.getStatus(), result.getStatus().toString());
        // Assertions.assertEquals(productDto.getCurrencyCode(), result.getCurrencyCode().toString());
        //Assertions.assertEquals(productDto.getManagerId(), result.getManager().getId());
    }

    @Test
    void statusParseString() {
    }

    @Test
    void currencyCodeParseString() {
    }

    @Test
    void parseInt() {
    }

    @Test
    void parseBigDecimal() {
    }

    @Test
    void currentDate() {
    }

    @Test
    void fromString() {
    }
}