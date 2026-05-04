package com.example.crudGyL.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ProductoRequestDto(
        @NotBlank(message = "El nombre no puede ser vacio")
        String nombre,

        @NotBlank(message = "El precio no puede ser vacio")
        @NotNull(message = "El precio es obligatorio")
        @Positive(message = "El precio debe ser mayor a Cero")
        Double precio,


        @NotBlank(message = "El Stock no puede ser vacio")
        @NotNull(message = "El Stock es obligatorio")
        @Positive(message = "El Stock debe ser Cero o mayor")
        Integer stock
) {

}
