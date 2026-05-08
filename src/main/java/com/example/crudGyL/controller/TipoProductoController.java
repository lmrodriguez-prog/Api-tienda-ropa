package com.example.crudGyL.controller;

import com.example.crudGyL.dto.request.TipoProductoRequestDto;
import com.example.crudGyL.dto.response.TipoProductoResponseDto;
import com.example.crudGyL.service.TipoProductoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
@RequiredArgsConstructor
public class TipoProductoController {

    private final TipoProductoService tipoProductoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TipoProductoResponseDto crear(@Valid @RequestBody TipoProductoRequestDto dto) {
        return tipoProductoService.crear(dto);
    }

    @GetMapping
    public List<TipoProductoResponseDto> listar() {
        return tipoProductoService.listarTodos();
    }

    @GetMapping("/{id}")
    public TipoProductoResponseDto buscarPorId(@PathVariable Long id) {
        return tipoProductoService.buscarPorId(id);
    }

    // Para categorías también podemos usar PATCH para darlas de baja
    @PatchMapping("/{id}/desactivar")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void desactivar(@PathVariable Long id) {
        // Suponiendo que implementaste eliminar en el service de tipos
        tipoProductoService.eliminar(id);
    }
}