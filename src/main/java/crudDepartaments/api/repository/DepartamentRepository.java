package crudDepartaments.api.repository;

import crudDepartaments.api.domain.Departament;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentRepository extends JpaRepository<Departament, Long> {
}
