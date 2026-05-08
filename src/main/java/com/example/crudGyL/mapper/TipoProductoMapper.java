package com.example.crudGyL.mapper;

import com.example.crudGyL.dto.request.TipoProductoRequestDto;
import com.example.crudGyL.dto.response.TipoProductoResponseDto;
import com.example.crudGyL.entity.TipoProducto;

public class TipoProductoMapper {

    public static TipoProducto toEntity(TipoProductoRequestDto dto) {
        if (dto == null) return null;
        TipoProducto tipo = new TipoProducto();
        tipo.setNombre(dto.nombre());
        tipo.setDescripcion(dto.descripcion());
        return tipo;
    }

    public static TipoProductoResponseDto toResponseDto(TipoProducto tipo) {
        if (tipo == null) return null;
        TipoProductoResponseDto dto = new TipoProductoResponseDto();
        dto.setId(tipo.getIdTipoProducto());
        dto.setNombre(tipo.getNombre());
        dto.setDescripcion(tipo.getDescripcion());
        return dto;
    }
}
