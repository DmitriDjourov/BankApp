package com.djourov.bankapp.controller.rest;

import com.djourov.bankapp.dto.ProductDto;
import com.djourov.bankapp.entity.Product;
import com.djourov.bankapp.service.interf.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app/product")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/products")// localhost:8080/app/product/products
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
//    {
//        "name": "CURRENT_ACCOUNT",
//        "managerId": "b407a7f7-b49f-11ee-9c53-00ffe0e1a544",
//        "limit": 1000,
//        "interestRate": 2.25,
//        "currencyCode": "EUR",
//        "status": "ACTIVE"
//    }
    @PostMapping("/create")// localhost:8080/app/product/create
    public Product createProduct(@RequestBody ProductDto productDto) {

        return productService.create(productDto);
    }
}
