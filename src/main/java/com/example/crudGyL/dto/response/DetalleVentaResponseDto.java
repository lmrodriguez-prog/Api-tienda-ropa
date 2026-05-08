package com.example.crudGyL.dto.response;

import lombok.Data;

@Data
public class DetalleVentaResponseDto {
    private Long id;
    private String nombreProducto;
    private Integer cantidad;
    private Double precioUnitario;
    private Double subtotal; // Cantidad x Precio
}