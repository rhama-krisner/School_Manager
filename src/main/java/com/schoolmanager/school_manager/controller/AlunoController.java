package com.schoolmanager.school_manager.controller;

import com.schoolmanager.school_manager.model.Aluno;
import com.schoolmanager.school_manager.repository.AlunoRepository;
import com.schoolmanager.school_manager.service.AlunoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
    private final AlunoRepository repository;
    private final AlunoService service;
    public AlunoController(AlunoRepository repository, AlunoService service) {
        this.repository = repository;
        this.service = service;
    }

    @GetMapping(value = {""})
    public List<Aluno> findAll() {
        return repository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Aluno findById(@PathVariable(value = "id") Long id) {
        Optional<Aluno> alunoOptional = repository.findById(id);

        return new ResponseEntity<>(alunoOptional.get(), HttpStatus.OK).getBody();
    }
    @PostMapping(value = "/novo")
    public Aluno create(@RequestBody Aluno aluno){
        return service.create(aluno);
    }
    @PutMapping(value = "/{id}")
    public Aluno update(@RequestBody Aluno aluno){
        return service.update(aluno);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Aluno> delete(@PathVariable(value = "id") Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
