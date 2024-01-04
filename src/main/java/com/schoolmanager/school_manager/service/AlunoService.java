package com.schoolmanager.school_manager.service;

import com.schoolmanager.school_manager.exceptions.ResourceNotFoundException;
import com.schoolmanager.school_manager.model.Aluno;
import com.schoolmanager.school_manager.repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {
    final AlunoRepository repository;

    public AlunoService(AlunoRepository repository) {
        this.repository = repository;
    }

    public Aluno findById(Long id) {
        Optional<Aluno> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Aluno.class.getName())
        );
    }

    public List<Aluno> findAll() {
        return repository.findAll();
    }

    public Aluno create(Aluno aluno) {
        return repository.save(aluno);
    }

    public Aluno update(Aluno aluno) {
        String msg = "Aluno não encontrado";
        return repository.findById(aluno.getId()).map(e -> {
            e.setNome(aluno.getNome());
            e.setEmail(aluno.getEmail());
            e.setDataNascimento(aluno.getDataNascimento());
            e.setSexo(aluno.getSexo());
            e.setCEP(aluno.getCEP());
            e.setRua(aluno.getRua());
            e.setBairro(aluno.getBairro());
            e.setNumero(aluno.getNumero());
            e.setCidade(aluno.getCidade());
            e.setCPF(aluno.getCPF());
            e.setNomeResponsavel(aluno.getNomeResponsavel());
            e.setEmailResponsavel(aluno.getEmailResponsavel());
            e.setContatoResponsavel(aluno.getContatoResponsavel());
            return repository.save(e);
        }).orElseThrow(
                () -> new ResourceNotFoundException(msg)
        );

    }

    public void delete(Long id) {
        Aluno entity = repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Sem dados encontrados para esse ID"));
        repository.delete(entity);
    }

}

