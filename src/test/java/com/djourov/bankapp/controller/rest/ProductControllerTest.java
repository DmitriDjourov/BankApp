package com.djourov.bankapp.controller.rest;

import com.djourov.bankapp.dto.ProductDto;
import com.djourov.bankapp.entity.Product;
import com.djourov.bankapp.util.DtoCreator;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
@Sql("/create-database-tables.sql")
@Sql("/create-database-triggers.sql")
@Sql("/test_database.sql")
class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
    @Test
    void createProductTest() throws Exception {
        ProductDto dto = DtoCreator.getPeodustDto();

        String creatPDTO = objectMapper.writeValueAsString(dto);

        MvcResult createProductResult = mockMvc
                .perform(MockMvcRequestBuilders.post("/app/product/create")
                                 .contentType(MediaType.APPLICATION_JSON)
                                 .content(creatPDTO))
                .andReturn();

        String productResultJSON = createProductResult.getResponse().getContentAsString();
        Product productResult = objectMapper.readValue(productResultJSON, Product.class);

        Assertions.assertEquals(201, createProductResult.getResponse().getStatus());
        Assertions.assertEquals(dto.getName(),productResult.getName());
        Assertions.assertEquals(dto.getManagerId(),productResult.getManager());
        Assertions.assertEquals(dto.getLimit(), productResult.getLimit());
        Assertions.assertEquals(dto.getInterestRate(), productResult.getInterestRate());
        Assertions.assertEquals(dto.getStatus(), productResult.getStatus());

    }
}