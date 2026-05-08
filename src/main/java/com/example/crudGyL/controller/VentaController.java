package com.example.crudGyL.controller;

import com.example.crudGyL.dto.request.VentaRequestDto;
import com.example.crudGyL.dto.response.VentaResponseDto;
import com.example.crudGyL.service.VentaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/ventas")
@RequiredArgsConstructor
public class VentaController {
    private final VentaService ventaService;

    @PostMapping
    public VentaResponseDto realizarVenta(@Valid @RequestBody VentaRequestDto dto) {
        return ventaService.realizarVenta(dto);
    }

    @GetMapping
    public List<VentaResponseDto> listar() {
        return ventaService.listarVentas();
    }
}