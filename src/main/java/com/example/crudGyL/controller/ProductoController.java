package com.example.crudGyL.controller;

import com.example.crudGyL.dto.ProductResponseDto;
import com.example.crudGyL.dto.ProductoRequestDto;
import com.example.crudGyL.entity.Producto;
import com.example.crudGyL.repository.ProductoRepository;
import com.example.crudGyL.service.ProductoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService productoService;
    @Autowired
    private ProductoRepository productoRepository;
    

    public ProductoController(ProductoService ProductoService) {
        this.productoService = ProductoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponseDto crear(@Valid @RequestBody ProductoRequestDto dto) {
        return productoService.crear(dto);
    }

    @GetMapping
    public List<ProductResponseDto> listar(){
        return productoService.listar();
    }

    @PutMapping("/{id}")
    public ProductResponseDto actualizar(@PathVariable Long id, @Valid @RequestBody ProductoRequestDto dto) {
        return productoService.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        productoService.eliminar(id);
    }

    @GetMapping("/{id}")
    public ProductResponseDto buscarPorId(@PathVariable Long id) {
        return productoService.buscarPorId(id);
    }

}



