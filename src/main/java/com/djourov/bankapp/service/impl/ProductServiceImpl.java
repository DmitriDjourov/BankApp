package com.djourov.bankapp.service.impl;

import com.djourov.bankapp.dto.ProductDto;
import com.djourov.bankapp.entity.Product;
import com.djourov.bankapp.entity.enums.ProductName;
import com.djourov.bankapp.exception.ProductWithThisNameAlreadyExistsException;
import com.djourov.bankapp.mapper.ProductMapper;
import com.djourov.bankapp.repository.ProductRepository;
import com.djourov.bankapp.service.interf.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

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
}


