package com.example.crudGyL.service;

import com.example.crudGyL.dto.request.ClienteRequestDto;
import com.example.crudGyL.dto.response.ClienteResponseDto;
import java.util.List;

public interface ClienteService {
    ClienteResponseDto crear(ClienteRequestDto dto);
    List<ClienteResponseDto> listarTodos();
    ClienteResponseDto buscarPorId(Long id);
    void eliminar(Long id);
}