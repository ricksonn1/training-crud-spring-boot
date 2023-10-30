package crudDepartaments.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DepartamentDTO(

        @NotNull
        Long id,

        @NotBlank
        String name,

        Long functionarys,

        @NotBlank
        String description

) {
}
