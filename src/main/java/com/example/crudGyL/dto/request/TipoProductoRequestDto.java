package com.example.crudGyL.dto.request;

import jakarta.validation.constraints.NotBlank;

public record TipoProductoRequestDto(
        @NotBlank(message = "El nombre de la categoría es obligatorio")
        String nombre,
        String descripcion
) {}