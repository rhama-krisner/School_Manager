package com.schoolmanager.school_manager.controller;

import com.schoolmanager.school_manager.model.Conta;
import com.schoolmanager.school_manager.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class LoginController {

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Conta conta) {
        Conta contaSalva = null;
        ResponseEntity response = null;

        try {
            String hashPwd = passwordEncoder.encode(conta.getPwd());
            conta.setPwd(hashPwd);
            conta.setCreateDt(LocalDateTime.now());
            contaSalva = contaRepository.save(conta);
            if (contaSalva.getId() > 0) {
                response = ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body("Given user details are successfully registered");
            }
        } catch (Exception ex) {
            response = ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An exception occured due to " + ex.getMessage());
        }
        return response;
    }

    @RequestMapping("/user")
    public Conta getUserDetailsAfterLogin(Authentication authentication) {
        List<Conta> customers = contaRepository.findByEmail(authentication.getName());
        if (customers.size() > 0) {
            return customers.get(0);
        } else {
            return null;
        }

    }

    @GetMapping("/allusers")
    public List<Conta> getAll() {
        return contaRepository.findAll();
    }
}
