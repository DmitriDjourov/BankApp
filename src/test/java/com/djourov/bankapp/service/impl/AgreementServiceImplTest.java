package com.djourov.bankapp.service.impl;

import com.djourov.bankapp.entity.Agreement;
import com.djourov.bankapp.repository.AgreementRepository;
import com.djourov.bankapp.util.EntityCreator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AgreementServiceImplTest {
    @Mock
    private AgreementRepository agreementRepository;
    @InjectMocks
    private AgreementServiceImpl agreementService;

    @Test
    void getAllAgreements() {
        List<Agreement> agreementList = new ArrayList<>();
        agreementList.add(EntityCreator.getAgreement());
        when(agreementRepository.findAll()).thenReturn(agreementList);
        List<Agreement> result = agreementService.getAllAgreements();
        Assertions.assertNotNull(result);
        Assertions.assertEquals(agreementList, result);
    }
}