package crudDepartaments.api.controller;


import crudDepartaments.api.dto.DepartamentDTO;
import crudDepartaments.api.domain.Departament;
import crudDepartaments.api.repository.DepartamentRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("departaments")
public class DepartamentController {

    @Autowired
    private DepartamentRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity createDepartament(@RequestBody @Valid DepartamentDTO data) {

        Departament newDepartament = new Departament(data);
        repository.save(newDepartament);
        return ResponseEntity.ok().build();

    }

    @GetMapping
    public ResponseEntity getAllDepartaments() {
        var departaments = repository.findAll();
        return ResponseEntity.ok(departaments);
    }

    @GetMapping("/{id}")
    public ResponseEntity getllDepartamentsById(@PathVariable Long id) {

        var departamentById = repository.findById(id);
        return ResponseEntity.ok(departamentById);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity updateDepartaments(@PathVariable Long id, @RequestBody @Valid DepartamentDTO data) {

        Optional<Departament> optionalDepartament = repository.findById(id);
        if (optionalDepartament.isPresent()) {
            Departament departament = optionalDepartament.get();
            departament.setName(data.name());
            departament.setFunctionarys(data.functionarys());
            departament.setDescription(data.description());
            return ResponseEntity.ok().build();
        } else {
            throw new EntityNotFoundException();
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletDepartament(@PathVariable Long id) {

        var delet = repository.getReferenceById(id);
        repository.delete(delet);

        return ResponseEntity.ok().build();
    }
}
