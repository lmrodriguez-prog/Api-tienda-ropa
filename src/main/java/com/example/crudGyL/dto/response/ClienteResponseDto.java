package com.example.crudGyL.dto.response;

import lombok.Data;

@Data
public class ClienteResponseDto {
    private Long id;
    private String nombre;
    private String email;
}