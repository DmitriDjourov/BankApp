package com.djourov.bankapp.service.impl;

import com.djourov.bankapp.dto.ProductDto;
import com.djourov.bankapp.entity.Product;
import com.djourov.bankapp.entity.enums.ProductName;
import com.djourov.bankapp.exception.ProductByIdNotFoundException;
import com.djourov.bankapp.exception.ProductWithThisNameAlreadyExistsException;
import com.djourov.bankapp.exception.message.ErrorMessages;
import com.djourov.bankapp.mapper.ProductMapper;
import com.djourov.bankapp.mapper.ProductMapperById;
import com.djourov.bankapp.repository.ProductRepository;
import com.djourov.bankapp.service.interf.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final ProductMapperById productMapperById;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product create(ProductDto productDto) {
        Product product = productRepository.getProductByName(ProductName.valueOf(productDto.getName()));
        if (product != null)
            throw new ProductWithThisNameAlreadyExistsException();
        else productRepository.save(productMapper.toEntity(productDto));
        return productRepository.getProductByName(ProductName.valueOf(productDto.getName()));
    }

    @Override
    public ProductDto getPBId(UUID id) {
        Product entity = productRepository.findById(id).orElseThrow(()-> new ProductByIdNotFoundException(ErrorMessages.NO_PRODUCT_WITH_ID, id));
        return productMapperById.toDto(entity);
    }
}


