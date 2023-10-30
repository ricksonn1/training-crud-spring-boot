package crudDepartaments.api.dto;

import jakarta.validation.constraints.NotBlank;

public record DepartamentDTO(

        @NotBlank
        String name,

        Long functionarys,

        @NotBlank
        String description

) {
}
