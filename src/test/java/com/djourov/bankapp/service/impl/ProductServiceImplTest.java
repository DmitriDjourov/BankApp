package com.djourov.bankapp.service.impl;

import com.djourov.bankapp.dto.ProductDto;
import com.djourov.bankapp.entity.Product;
import com.djourov.bankapp.entity.enums.ProductName;
import com.djourov.bankapp.exception.ProductByIdNotFoundException;
import com.djourov.bankapp.exception.ProductWithThisNameAlreadyExistsException;
import com.djourov.bankapp.mapper.ProductMapper;
import com.djourov.bankapp.mapper.ProductMapperById;
import com.djourov.bankapp.repository.ProductRepository;
import com.djourov.bankapp.util.DtoCreator;
import com.djourov.bankapp.util.EntityCreator;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {
    @Mock
    private ProductRepository productRepository;
    @Mock
    private ProductMapper productMapper;
    @Mock
    private ProductMapperById productMapperById;
    @InjectMocks
    private ProductServiceImpl productService;

    @AfterEach
    public void clearMocks() {
        clearInvocations(productRepository, productMapper, productMapperById);
    }

    @Test
    void getAllProductsTest() {
        List<Product> productList = new ArrayList<>();
        productList.add(EntityCreator.getProduct());
        when(productRepository.findAll()).thenReturn(productList);
        List<Product> result = productService.getAllProducts();
        Assertions.assertNotNull(result);
        Assertions.assertEquals(productList, result);
    }

   @Test
    void createTest() {
       Product product = EntityCreator.getProduct();
       ProductDto productDto = DtoCreator.getProductDto();
       when(productMapper.toEntity(productDto)).thenReturn(product);
       when(productRepository.getProductByName(ProductName.valueOf(productDto.getName()))).thenReturn(null);
       when(productRepository.save(product)).thenReturn(product);
       verify(productMapper, times(1)).toEntity(productDto);
       verify(productRepository, times(1)).save(product);
    }

    @Test
    void Create_WhenProductExistsExceptionTest(){
        Product product = EntityCreator.getProduct();
        ProductDto productDto = DtoCreator.getProductDto();
        when(productRepository.getProductByName(ProductName.valueOf(productDto.getName()))).thenReturn(product);
        Assertions.assertThrows(ProductWithThisNameAlreadyExistsException.class, () -> productService.create(productDto));
        verify(productRepository, never()).save(any());
    }

    @Test
    void getPBIdTest() {
        Product product = EntityCreator.getProduct();
        ProductDto productDto = DtoCreator.getProductDto();
        when(productRepository.findById(product.getId())).thenReturn(Optional.of(product));
        when(productMapperById.toDto(product)).thenReturn(productDto);

        ProductDto actualProductDto = productService.getPBId(product.getId());
        Assert.assertEquals(actualProductDto, productDto);
    }

    @Test
    void getPBIdThrowExceptionTest(){
        UUID id = EntityCreator.getProduct().getId();
        when(productRepository.findById(id)).thenReturn(Optional.empty());
        Assertions.assertThrows(ProductByIdNotFoundException.class, () -> productService.getPBId(id));
    }
}