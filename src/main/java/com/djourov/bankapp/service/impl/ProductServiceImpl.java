package com.djourov.bankapp.service.impl;

import com.djourov.bankapp.entity.Product;
import com.djourov.bankapp.repository.ProductRepository;
import com.djourov.bankapp.service.interf.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    @Override
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

}
