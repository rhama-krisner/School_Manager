package com.schoolmanager.school_manager.controller;

import com.schoolmanager.school_manager.model.Aluno;
import com.schoolmanager.school_manager.model.Professor;
import com.schoolmanager.school_manager.repository.ProfessorRepository;
import com.schoolmanager.school_manager.service.ProfessorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/professor")
public class ProfessorController {
    private final ProfessorRepository repository;
    private final ProfessorService service;

    public ProfessorController(ProfessorRepository repository, ProfessorService service) {
        this.repository = repository;
        this.service = service;
    }

    @GetMapping(value = {""})
    public List<Professor> findAll() {
        return repository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Professor findById(@PathVariable(value = "id") Long id) {
        Optional<Professor> professorOptional = repository.findById(id);
        return new ResponseEntity<>(professorOptional.get(), HttpStatus.OK).getBody();
    }

    @PostMapping(value = "/novo")
    public Professor create(@RequestBody Professor professor) {
        return service.create(professor);
    }

    @PutMapping(value = "/{id}")
    public Professor update(@RequestBody Professor professor) {
        return service.update(professor);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Professor> delete(@PathVariable(value = "id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
