package com.example.crudGyL.mapper;

import com.example.crudGyL.dto.response.DetalleVentaResponseDto;
import com.example.crudGyL.entity.DetalleVenta;

public class DetalleVentaMapper {

    public static DetalleVentaResponseDto toResponseDto(DetalleVenta detalle) {
        if (detalle == null) return null;

        DetalleVentaResponseDto dto = new DetalleVentaResponseDto();
        dto.setId(detalle.getIdDetalleVenta());
        dto.setNombreProducto(detalle.getProducto().getNombre());
        dto.setCantidad(detalle.getCantidad());
        dto.setPrecioUnitario(detalle.getPrecioUnitario());
        dto.setSubtotal(detalle.getCantidad() * detalle.getPrecioUnitario());

        return dto;
    }
}