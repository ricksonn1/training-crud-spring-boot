package crudDepartaments.api.domain;


import crudDepartaments.api.dto.DepartamentDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "departaments")
@Entity(name = "departament")
public class Departament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long functionarys;
    private String description;


    public Departament(DepartamentDTO data) {
        this.name = data.name();
        this.functionarys = data.functionarys();
        this.description = data.description();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getFunctionarys() {
        return functionarys;
    }

    public void setFunctionarys(Long functionarys) {
        this.functionarys = functionarys;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void updateDepartament(DepartamentDTO data) {
        if (data.name() != null) {
            this.name = data.name();
        }
        if (data.functionarys() != null) {
            this.functionarys = data.functionarys();
        }
        if (data.description() != null) {
            this.description = data.description();
        }
    }
}
