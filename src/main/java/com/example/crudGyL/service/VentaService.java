package com.example.crudGyL.service;

import com.example.crudGyL.dto.request.VentaRequestDto;
import com.example.crudGyL.dto.response.VentaResponseDto;
import java.util.List;

public interface VentaService {
    VentaResponseDto realizarVenta(VentaRequestDto dto);
    List<VentaResponseDto> listarVentas();
    VentaResponseDto buscarVentaPorId(Long id);
}
