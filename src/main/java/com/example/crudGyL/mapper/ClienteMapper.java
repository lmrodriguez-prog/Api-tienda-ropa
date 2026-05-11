package com.example.crudGyL.mapper;

import com.example.crudGyL.dto.request.ClienteRequestDto;
import com.example.crudGyL.dto.response.ClienteResponseDto;
import com.example.crudGyL.entity.Cliente;

public class ClienteMapper {

    // Para el POST y el PUT (De pedido a base de datos)
    public static Cliente toEntity(ClienteRequestDto dto) {
        if (dto == null) return null;

        Cliente cliente = new Cliente();
        cliente.setNombre(dto.nombre());
        cliente.setApellido(dto.apellido());
        cliente.setCorreo(dto.email());
        cliente.setTelefono(dto.telefono());
        cliente.setDireccion(dto.direccion());

        return cliente;
    }

    public static ClienteResponseDto toResponseDto(Cliente cliente) {
        if (cliente == null) return null;

        ClienteResponseDto dto = new ClienteResponseDto();
        dto.setId(cliente.getId_cliente());
        dto.setNombre(cliente.getNombre());
        dto.setApellido(cliente.getApellido());
        dto.setCorreo(cliente.getCorreo());
        dto.setTelefono(cliente.getTelefono());
        dto.setDireccion(cliente.getDireccion());
        dto.setEstadoCLiente(cliente.getEstadoCliente());
        return dto;
    }
}