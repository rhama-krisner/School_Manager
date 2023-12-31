package com.schoolmanager.school_manager;

import com.schoolmanager.school_manager.model.Authority;
import com.schoolmanager.school_manager.model.Conta;
import com.schoolmanager.school_manager.repository.AuthorityRepository;
import com.schoolmanager.school_manager.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.Arrays;

@SpringBootApplication
public class SchoolManagerApplication implements CommandLineRunner {

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public static void main(String[] args) {
        SpringApplication.run(SchoolManagerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Authority auth1 = new Authority(null, "ROLE_ADMIN");
        Authority auth2 = new Authority(null, "ROLE_SECRETARIA");

        authorityRepository.saveAll(Arrays.asList(auth1, auth2));

        Conta c1 = new Conta(null, "Admito", "admito@example.com", "11994212145", passwordEncoder().encode("12345"), "admin", LocalDateTime.now());

        contaRepository.saveAll(Arrays.asList(c1));
    }

}
