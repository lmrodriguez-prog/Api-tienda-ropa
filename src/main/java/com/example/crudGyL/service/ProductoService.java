package com.example.crudGyL.service;

import com.example.crudGyL.dto.ProductResponseDto;
import com.example.crudGyL.dto.ProductoRequestDto;

import java.util.List;

public interface ProductoService {

    <ProductResponseDto> ProductResponseDto crear(ProductoRequestDto dto);

    List<ProductResponseDto> listar();

    ProductResponseDto buscarPorId(Long id);

    ProductResponseDto actualizar(Long id,  ProductoRequestDto dto);

    void eliminar(Long id);

    List<ProductResponseDto> busquedaNombre(String nombre);
}
