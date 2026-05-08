package com.example.crudGyL.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record ProductoRequestDto(
        @NotBlank(message = "El nombre no puede estar vacío")
        String nombre,

        @NotNull(message = "El precio es obligatorio")
        @PositiveOrZero(message = "El precio debe ser cero o mayor")
        Double precio,

        @NotNull(message = "El stock es obligatorio")
        @PositiveOrZero(message = "El stock debe ser cero o mayor")
        Integer stock,

        @NotNull(message = "El ID de categoría es obligatorio")
        Long idTipoProducto
) {}