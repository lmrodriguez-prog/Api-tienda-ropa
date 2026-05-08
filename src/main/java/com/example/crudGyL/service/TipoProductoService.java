package com.example.crudGyL.service;

import com.example.crudGyL.dto.request.TipoProductoRequestDto;
import com.example.crudGyL.dto.response.TipoProductoResponseDto;
import java.util.List;

public interface TipoProductoService {
    TipoProductoResponseDto crear(TipoProductoRequestDto dto);
    List<TipoProductoResponseDto> listarTodos();

    TipoProductoResponseDto buscarPorId(Long id);

    void eliminar(Long id);
}