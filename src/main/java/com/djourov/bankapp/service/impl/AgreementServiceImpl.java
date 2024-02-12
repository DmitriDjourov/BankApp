package com.djourov.bankapp.service.impl;

import com.djourov.bankapp.entity.Agreement;
import com.djourov.bankapp.repository.AgreementRepository;
import com.djourov.bankapp.service.interf.AgreementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AgreementServiceImpl implements AgreementService {

    private final AgreementRepository agreementRepository;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, readOnly = true)
    public List<Agreement> getAllAgreements() {
        return agreementRepository.findAll();
    }
}
