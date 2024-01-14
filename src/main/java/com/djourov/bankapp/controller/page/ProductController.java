package com.djourov.bankapp.controller.page;

import com.djourov.bankapp.entity.Product;
import com.djourov.bankapp.service.interf.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/app/product")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/products")//http:/localhost:8080/app/product/products
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

}
