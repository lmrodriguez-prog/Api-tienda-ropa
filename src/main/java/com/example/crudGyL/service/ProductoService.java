package com.example.crudGyL.service;

import com.example.crudGyL.dto.request.ProductoRequestDto;
import com.example.crudGyL.dto.response.ProductoResponseDto; // Importamos el nombre correcto

import java.util.List;

public interface ProductoService {

    ProductoResponseDto crear(ProductoRequestDto dto);

    List<ProductoResponseDto> listar();

    ProductoResponseDto buscarPorId(Long id);

    ProductoResponseDto actualizar(Long id, ProductoRequestDto dto);

    void eliminar(Long id);

    List<ProductoResponseDto> busquedaNombre(String nombre);
}