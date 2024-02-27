package com.djourov.bankapp.controller.rest;

import com.djourov.bankapp.dto.ProductDto;
import com.djourov.bankapp.entity.Product;
import com.djourov.bankapp.service.impl.ProductServiceImpl;
import com.djourov.bankapp.util.DtoCreator;
import com.djourov.bankapp.util.EntityCreator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
@DisplayName("ProductController test class")
class ProductControllerTest {
    @Autowired
    ProductController productController;

    @MockBean
    private ProductServiceImpl productService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getProductByIdTest() throws Exception {
        Product product = EntityCreator.getProduct();
        ProductDto productDto = DtoCreator.getProductDto();
        when(productService.getPBId(product.getId())).thenReturn(productDto);
        mockMvc.perform(get("/app/product/{id}", product.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(productDto.getName())))
                .andExpect(jsonPath("$.managerId", is(productDto.getManagerId())))
                .andExpect(jsonPath("$.limit", is(productDto.getLimit())))
                .andExpect(jsonPath("$.interestRate", is(productDto.getInterestRate())))
                .andExpect(jsonPath("$.currencyCode", is(productDto.getCurrencyCode())))
                .andExpect(jsonPath("$.status", is(productDto.getStatus())));
    }

    @Test
    void getAllProductsTest() throws Exception {
        Product product = EntityCreator.getProduct();
        List<Product> products = new ArrayList<>();
        products.add(product);
        when(productService.getAllProducts()).thenReturn(products);
        mockMvc.perform(get("/app/product/products"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name").value(product.getName().toString()))
                .andExpect(jsonPath("$[0].limit").value(product.getLimit()))
                .andExpect(jsonPath("$[0].interestRate").value(product.getInterestRate().floatValue()))
                .andExpect(jsonPath("$[0].currencyCode").value(product.getCurrencyCode().toString()))
                .andExpect(jsonPath("$[0].status").value(product.getStatus().toString()));
        ;

    }

    @Test
    void createProductTest() throws Exception {
        Product product = EntityCreator.getProduct();
        ProductDto productDto = DtoCreator.getProductDto();
    }
}