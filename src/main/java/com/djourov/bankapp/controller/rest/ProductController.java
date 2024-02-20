package com.djourov.bankapp.controller.rest;

import com.djourov.bankapp.dto.ProductDto;
import com.djourov.bankapp.entity.Product;
import com.djourov.bankapp.service.interf.ProductService;
import com.djourov.bankapp.validation.annotation.UuidChecker;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
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
    @Operation(summary = "The method returns information about product by its identifier",
            description = "This method returns a complete product record from the products table by the product's unique identifier.",
            tags = "Products",
            externalDocs = @ExternalDocumentation(
                    description = "Documentation",
                    url = "https://google.com/"
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Found"),
                    @ApiResponse(responseCode = "500", description = "Not Found")
            },
            security = {
                    @SecurityRequirement(name = "security requirements")
            },
            hidden = false
    )
    public ProductDto getProductById(@UuidChecker @PathVariable UUID id) {
        return productService.getPBId(id);
    }

    @GetMapping("/products")// localhost:8080/app/product/products
    @Operation(summary = "The method returns information about products from the clients table",
            description = "The method returns the values of all fields of all records from the products table",
            tags = "Products",
            externalDocs = @ExternalDocumentation(
                    description = "Documentation",
                    url = "https://google.com/"
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Found"),
                    @ApiResponse(responseCode = "500", description = "Not Found")
            },
            security = {
                    @SecurityRequirement(name = "security requirements")
            },
            hidden = false
    )
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
    @Operation(summary = "Method for creating a new product",
            description = "This method creates a new product and enters all the necessary data into the products table.",
            tags = "Products",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Product data to save",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ProductDto.class)
                    )
            )
    )
    public Product createProduct(@RequestBody ProductDto productDto) {
        return productService.create(productDto);
    }
}
