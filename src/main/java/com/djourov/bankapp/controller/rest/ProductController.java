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
//        "name": "CURRENT_ACCOUNT"
//    }
    @PostMapping("/create")// localhost:8080/app/product/create
    public Product createProduct(@RequestBody ProductDto productDto) {
        return productService.create(productDto);
    }
}
