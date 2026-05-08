package com.example.crudGyL.dto.response;

import lombok.Data;

@Data
public class ProductoResponseDto {
        private Long id;
        private String nombre;
        private Double precio;
        private Integer stock;
        private String nombreTipo; // Para que muestre "Vestido" y no solo un número
}
