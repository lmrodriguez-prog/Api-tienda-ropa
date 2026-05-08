package com.example.crudGyL.mapper;

import com.example.crudGyL.dto.request.ProductoRequestDto;
import com.example.crudGyL.dto.response.ProductoResponseDto;
import com.example.crudGyL.entity.Producto;

public class ProductoMapper {

    private ProductoMapper() {

    }

    public static Producto toEntity(ProductoRequestDto dto) {
        if (dto == null) return null;

        Producto producto = new Producto();
        producto.setNombre(dto.nombre());
        producto.setPrecio(dto.precio());
        producto.setStock(dto.stock());

        return producto;
    }

    public static ProductoResponseDto toResponseDto(Producto producto) {
        if (producto == null) return null;

        ProductoResponseDto dto = new ProductoResponseDto();
        dto.setId(producto.getIdProducto());
        dto.setNombre(producto.getNombre());
        dto.setPrecio(producto.getPrecio());
        dto.setStock(producto.getStock());


        if (producto.getTipoProducto() != null) {
            dto.setNombreTipo(producto.getTipoProducto().getNombre());
        }

        return dto;
    }

    public static void updateEntity(Producto producto, ProductoRequestDto dto) {
        if (dto == null || producto == null) return;

        producto.setNombre(dto.nombre());
        producto.setPrecio(dto.precio());
        producto.setStock(dto.stock());
    }
}