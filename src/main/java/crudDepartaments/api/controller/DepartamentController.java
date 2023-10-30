package crudDepartaments.api.controller;


import crudDepartaments.api.dto.DepartamentDTO;
import crudDepartaments.api.domain.Departament;
import crudDepartaments.api.repository.DepartamentRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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

}
