package com.example.crudGyL.dto.response;

import lombok.Data;

@Data
public class ClienteResponseDto {
    private Long id;
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    private String direccion;
    private Boolean estadoCLiente;

    }

