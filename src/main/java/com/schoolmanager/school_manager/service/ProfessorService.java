package com.schoolmanager.school_manager.service;

import com.schoolmanager.school_manager.exceptions.ResourceNotFoundException;
import com.schoolmanager.school_manager.model.Aluno;
import com.schoolmanager.school_manager.model.Professor;
import com.schoolmanager.school_manager.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {
    final ProfessorRepository repository;
    public ProfessorService(ProfessorRepository repository) {
        this.repository = repository;
    }

    public Professor findById(Long id){
        Optional<Professor> obj = repository.findById(id);
        return obj.orElseThrow(()->new ResourceNotFoundException(
                "Objeto não encontrado! ID: " + id + ", Tipo: " + Professor.class.getName())
        );
    }

    public List<Professor> findAll() {
        return repository.findAll();
    }

    public Professor create(Professor professor) {
        return repository.save(professor);
    }

    public Professor update(Professor professor) {
        Professor repo = repository.findById(professor.getId()).orElseThrow(
                () -> new ResourceNotFoundException("Não foi encontrado pessoas com esse ID"));

        Class<? extends Professor> clazz = repo.getClass();
        for (Method method : clazz.getMethods()) {
            if (method.getName().startsWith("set")) {
                try {
                    String methodName = method.getName().substring(3);
                    Method getMethod = clazz.getMethod("get" + methodName);
                    Object value = getMethod.invoke(professor);
                    method.invoke(repo, value);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }

        return repository.save(repo);
    }

    public void delete(Long id) {
        Professor entity = repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Sem dados encontrados para esse ID"));
        repository.delete(entity);
    }

}
