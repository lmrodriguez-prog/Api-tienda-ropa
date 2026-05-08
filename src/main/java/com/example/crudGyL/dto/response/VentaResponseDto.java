package com.example.crudGyL.dto.response;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class VentaResponseDto {
    private Long id;
    private LocalDateTime fecha;
    private String nombreCliente;
    private List<DetalleVentaResponseDto> detalles;
    private Double total;
}