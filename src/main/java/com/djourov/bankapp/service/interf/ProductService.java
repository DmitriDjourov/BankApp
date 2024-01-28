package com.djourov.bankapp.service.interf;

import com.djourov.bankapp.dto.ProductDto;
import com.djourov.bankapp.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Product create(ProductDto productDto);
}
