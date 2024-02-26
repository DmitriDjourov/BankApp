package com.djourov.bankapp.controller.rest;

import com.djourov.bankapp.entity.Agreement;
import com.djourov.bankapp.service.impl.AgreementServiceImpl;
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
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@WebMvcTest(AgreementController.class)
@DisplayName("AgreementController test class")
class AgreementControllerTest {
    @Autowired
    AgreementController agreementController;

    @MockBean
    private AgreementServiceImpl agreementService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAgreementTest() throws Exception {
        List<Agreement> agreements = new ArrayList<>();
        agreements.add(EntityCreator.getAgreement());
        Agreement agreement = EntityCreator.getAgreement();
        when(agreementService.getAllAgreements()).thenReturn(agreements);
        mockMvc.perform(get("/app/agreement/agreements"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id").value(agreement.getId().toString()))
                .andExpect(jsonPath("$[0].interestRate").value(agreement.getInterestRate().floatValue()))
                .andExpect(jsonPath("$[0].status").value(agreement.getStatus().name()))
                .andExpect(jsonPath("$[0].sum").value(agreement.getSum().floatValue()))
                .andExpect(jsonPath("$[0].createdAt").value(agreement.getCreatedAt().toString()))
                .andExpect(jsonPath("$[0].updatedAt").value(agreement.getUpdatedAt().toString()));
    }
}