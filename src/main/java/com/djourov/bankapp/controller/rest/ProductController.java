package com.djourov.bankapp.controller.rest;

import com.djourov.bankapp.dto.ProductDto;
import com.djourov.bankapp.entity.Product;
import com.djourov.bankapp.service.interf.ProductService;
import com.djourov.bankapp.validation.annotation.UuidChecker;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/app/product")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/{id}")//localhost:8080/app/product/1b109afa-c45d-11ee-bf28-00155d558765
    public ProductDto getProductById(@UuidChecker @PathVariable UUID id){
        return productService.getPBId(id);
    }

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
