package com.djourov.bankapp.controller.page;

import com.djourov.bankapp.entity.Agreement;
import com.djourov.bankapp.service.interf.AgreementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/app/agreement")
@RequiredArgsConstructor
public class AgreementController {

    private final AgreementService agreementService;

    @GetMapping("/agreements")//http:/localhost:8080/app/agreement/agreements
    public List<Agreement> getAllagreement() {
        return agreementService.getAllAgreements();
    }

}
