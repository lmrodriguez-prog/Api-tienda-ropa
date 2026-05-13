package com.example.crudGyL.service.impl;

import com.example.crudGyL.dto.request.ProductoRequestDto;
import com.example.crudGyL.dto.response.ProductoResponseDto;
import com.example.crudGyL.entity.Producto;
import com.example.crudGyL.entity.TipoProducto;
import com.example.crudGyL.exception.RecursosNoEncontradoException;
import com.example.crudGyL.mapper.ProductoMapper;
import com.example.crudGyL.repository.ProductoRepository;
import com.example.crudGyL.repository.TipoProductoRepository;
import com.example.crudGyL.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;
    private final TipoProductoRepository tipoProductoRepository;

    @Override
    public ProductoResponseDto crear(ProductoRequestDto dto) {

        TipoProducto tipo = tipoProductoRepository.findById(dto.idTipoProducto())
                .orElseThrow(() -> new RecursosNoEncontradoException("No existe la categoría con ID: " + dto.idTipoProducto()));

        Producto producto = ProductoMapper.toEntity(dto);
        producto.setTipoProducto(tipo);

        Producto guardado = productoRepository.save(producto);
        return ProductoMapper.toResponseDto(guardado);
    }

    @Override
    public List<ProductoResponseDto> listar() {
        return productoRepository.findAll()
                .stream()
                .map(ProductoMapper::toResponseDto)
                .toList();
    }

    @Override
    public ProductoResponseDto buscarPorId(Long id) {
        return productoRepository.findById(id)
                .map(ProductoMapper::toResponseDto)
                .orElseThrow(() -> new RecursosNoEncontradoException("No se encontró el Producto con ID: " + id));
    }

    @Override
    public ProductoResponseDto actualizar(Long id, ProductoRequestDto dto) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new RecursosNoEncontradoException("No se encontró el Producto con ID: " + id));

        ProductoMapper.updateEntity(producto, dto);

        TipoProducto tipo = tipoProductoRepository.findById(dto.idTipoProducto())
                .orElseThrow(() -> new RecursosNoEncontradoException("No existe la categoría con ID: " + dto.idTipoProducto()));
        producto.setTipoProducto(tipo);

        Producto guardado = productoRepository.save(producto);
        return ProductoMapper.toResponseDto(guardado);
    }

    @Override
    public void eliminar(Long id) {
        if (!productoRepository.existsById(id)) {
            throw new RecursosNoEncontradoException("No se puede eliminar: No existe el ID " + id);
        }
        productoRepository.deleteById(id);
    }

    @Override
    public List<ProductoResponseDto> busquedaNombre(String nombre) {
        return productoRepository.findByNombre(nombre)
                .stream()
                .map(ProductoMapper::toResponseDto)
                .toList();
    }

    public void desactivar(Long id) {
        Producto p = productoRepository.findById(id).orElseThrow();
        p.setActivo(false);
        productoRepository.save(p);
    }

    public void activar(Long id) {
        Producto p = productoRepository.findById(id).orElseThrow();
        p.setActivo(true);
        productoRepository.save(p);
    }

}