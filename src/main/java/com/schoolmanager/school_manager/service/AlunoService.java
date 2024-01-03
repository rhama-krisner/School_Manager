package com.schoolmanager.school_manager.service;

import com.schoolmanager.school_manager.exceptions.ResourceNotFoundException;
import com.schoolmanager.school_manager.model.Aluno;
import com.schoolmanager.school_manager.repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Objects;
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
        Aluno repo = repository.findById(aluno.getId()).orElseThrow(
                () -> new ResourceNotFoundException("Não foi encontrado pessoas com esse ID"));

        Class<? extends Aluno> clazz = repo.getClass();
        for (Method method : clazz.getMethods()) {
            if (method.getName().startsWith("set")) {
                try {
                    String methodName = method.getName().substring(3);
                    Method getMethod = clazz.getMethod("get" + methodName);
                    Object value = getMethod.invoke(aluno);
                    method.invoke(repo, value);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }

        return repository.save(repo);
    }

    public void delete(Long id) {
        Aluno entity = repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Sem dados encontrados para esse ID"));
        repository.delete(entity);
    }

}

