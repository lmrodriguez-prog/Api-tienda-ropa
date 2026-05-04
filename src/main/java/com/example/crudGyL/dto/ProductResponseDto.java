package com.example.crudGyL.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDto {
        Long id;
        String nombre;
        Double precio;
        Integer stock;
}

