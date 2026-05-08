package com.example.crudGyL.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;

public record VentaRequestDto(
        @NotNull(message = "El ID del cliente es obligatorio")
        Long idCliente,

        @NotEmpty(message = "La venta debe tener al menos un producto")
        List<DetalleVentaRequestDto> detalles
) {}