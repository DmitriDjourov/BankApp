package com.djourov.bankapp.mapper;

import com.djourov.bankapp.dto.ProductDto;
import com.djourov.bankapp.entity.Product;
import com.djourov.bankapp.util.EntityCreator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ProductMapperByIdTest {
private final ProductMapperById productMapperById = new ProductMapperByIdImpl();
    @Test
    void toDtoProductMapperByIdTest() {
        Product product = EntityCreator.getProduct();
        ProductDto productDto = productMapperById.toDto(product);
        Assertions.assertNotNull(productDto);
        Assertions.assertEquals(product.getName().toString(),productDto.getName());
        Assertions.assertEquals(product.getManager(), productDto.getManagerId());
        Assertions.assertEquals(product.getLimit(),Integer.parseInt(productDto.getLimit()));
        Assertions.assertEquals(product.getInterestRate().toString(),productDto.getInterestRate());
        Assertions.assertEquals(product.getCurrencyCode().toString(),productDto.getCurrencyCode());
        Assertions.assertEquals(product.getStatus().toString(),productDto.getStatus());
    }
}
