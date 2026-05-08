package com.example.crudGyL.mapper;

import com.example.crudGyL.dto.request.ClienteRequestDto;
import com.example.crudGyL.dto.response.ClienteResponseDto;
import com.example.crudGyL.entity.Cliente;

public class ClienteMapper {

    public static Cliente toEntity(ClienteRequestDto dto) {
        if (dto == null) return null;
        Cliente cliente = new Cliente();
        cliente.setNombre(dto.nombre());
        cliente.setEmail(dto.email());
        return cliente;
    }

    public static ClienteResponseDto toResponseDto(Cliente cliente) {
        if (cliente == null) return null;
        ClienteResponseDto dto = new ClienteResponseDto();
        dto.setId(cliente.getIdCliente());
        dto.setNombre(cliente.getNombre());
        dto.setEmail(cliente.getEmail());
        return dto;
    }
}
