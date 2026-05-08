package com.example.crudGyL.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ApiErrorDto {
    private String mensaje;
    private int codigoEstado;
    private LocalDateTime fecha;
}