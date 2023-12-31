package com.schoolmanager.school_manager.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlunoController {

    @GetMapping("/teste")
    public String teste () {
        return "Teste";
    }

}
