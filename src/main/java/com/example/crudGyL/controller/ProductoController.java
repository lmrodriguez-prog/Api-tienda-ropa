package com.example.crudGyL.controller;

import com.example.crudGyL.dto.request.ProductoRequestDto;
import com.example.crudGyL.dto.response.ProductoResponseDto;
import com.example.crudGyL.service.ProductoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/productos")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoService productoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductoResponseDto crear(@Valid @RequestBody ProductoRequestDto dto) {
        return productoService.crear(dto);
    }

    @GetMapping
    public List<ProductoResponseDto> listar() {
        return productoService.listar();
    }

    @PutMapping("/{id}") // Actualización TOTAL
    public ProductoResponseDto actualizar(@PathVariable Long id, @Valid @RequestBody ProductoRequestDto dto) {
        return productoService.actualizar(id, dto);
    }

    @PatchMapping("/{id}/desactivar") // PATCH para BAJA LÓGICA
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void desactivar(@PathVariable Long id) {
        productoService.eliminar(id);
    }

    @GetMapping("/{id}")
    public ProductoResponseDto buscarPorId(@PathVariable Long id) {
        return productoService.buscarPorId(id);
    }
}
