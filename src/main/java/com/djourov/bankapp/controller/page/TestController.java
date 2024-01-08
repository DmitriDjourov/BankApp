package com.djourov.bankapp.controller.page;

import com.djourov.bankapp.entity.Account;
import com.djourov.bankapp.service.interf.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/test")//https:/google.com/test
public class TestController {

  private final TestService testService;
    @GetMapping("/acc/{id}")//https:/google.com/test/acc/0c70afa1-c654-471d-9cb2-437ac289d62c
    public Account getAccountByID(@PathVariable("id") String id){
        return testService.getAccById(id);
    }

}
