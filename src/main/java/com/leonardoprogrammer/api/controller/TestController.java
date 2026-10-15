package com.leonardoprogrammer.api.controller;

import com.leonardoprogrammer.api.enums.ApiVersao;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiVersao.V1 + "/test")
public class TestController {

    @GetMapping("/ping")
    public String ping() {
        return "Ok";
    }
}
