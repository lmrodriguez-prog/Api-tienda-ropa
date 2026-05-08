package com.example.crudGyL.mapper;

import com.example.crudGyL.dto.response.VentaResponseDto;
import com.example.crudGyL.entity.Venta;
import java.util.stream.Collectors;

public class VentaMapper {

    public static VentaResponseDto toResponseDto(Venta venta) {
        if (venta == null) return null;

        VentaResponseDto dto = new VentaResponseDto();
        dto.setId(venta.getIdVenta());
        dto.setFecha(venta.getFecha());
        dto.setNombreCliente(venta.getCliente().getNombre());
        dto.setTotal(venta.getTotal());

        if (venta.getDetalles() != null) {
            dto.setDetalles(venta.getDetalles().stream()
                    .map(DetalleVentaMapper::toResponseDto)
                    .collect(Collectors.toList()));
        }

        return dto;
    }
}