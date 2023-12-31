package com.schoolmanager.school_manager.repository;

import com.schoolmanager.school_manager.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {

    List<Conta> findByEmail(String email);
}
