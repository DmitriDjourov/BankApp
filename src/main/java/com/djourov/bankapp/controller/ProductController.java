package com.djourov.bankapp.controller;

import com.djourov.bankapp.entity.Product;
import com.djourov.bankapp.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/app/products")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;
    @GetMapping("/")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

}
