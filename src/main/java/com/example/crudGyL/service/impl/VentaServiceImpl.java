package com.example.crudGyL.service.impl;

import com.example.crudGyL.dto.request.VentaRequestDto;
import com.example.crudGyL.dto.response.VentaResponseDto;
import com.example.crudGyL.entity.*;
import com.example.crudGyL.exception.RecursosNoEncontradoException;
import com.example.crudGyL.mapper.VentaMapper;
import com.example.crudGyL.repository.*;
import com.example.crudGyL.service.VentaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VentaServiceImpl implements VentaService {

    private final VentaRepository ventaRepository;
    private final ClienteRepository clienteRepository;
    private final ProductoRepository productoRepository;

    @Override
    @Transactional
    public VentaResponseDto realizarVenta(VentaRequestDto dto) {
        // 1. Buscar Cliente
        Cliente cliente = clienteRepository.findById(dto.idCliente())
                .orElseThrow(() -> new RecursosNoEncontradoException("Cliente no encontrado"));

        Venta venta = new Venta();
        venta.setCliente(cliente);
        venta.setFecha(LocalDateTime.now());
        venta.setTotal(0.0);

        List<DetalleVenta> detalles = new ArrayList<>();
        double totalAcumulado = 0.0;

        // 2. Procesar productos y descontar stock
        for (var detalleDto : dto.detalles()) {
            Producto producto = productoRepository.findById(detalleDto.idProducto())
                    .orElseThrow(() -> new RecursosNoEncontradoException("Producto no encontrado: " + detalleDto.idProducto()));

            if (producto.getStock() < detalleDto.cantidad()) {
                throw new RuntimeException("Stock insuficiente para: " + producto.getNombre());
            }

            producto.setStock(producto.getStock() - detalleDto.cantidad());
            productoRepository.save(producto);

            DetalleVenta detalle = new DetalleVenta();
            detalle.setVenta(venta);
            detalle.setProducto(producto);
            detalle.setCantidad(detalleDto.cantidad());
            detalle.setPrecioUnitario(producto.getPrecio());

            detalles.add(detalle);
            totalAcumulado += producto.getPrecio() * detalleDto.cantidad();
        }

        venta.setDetalles(detalles);
        venta.setTotal(totalAcumulado);

        return VentaMapper.toResponseDto(ventaRepository.save(venta));
    }

    @Override
    public List<VentaResponseDto> listarVentas() {
        return ventaRepository.findAll().stream()
                .map(VentaMapper::toResponseDto)
                .toList();
    }

    @Override
    public VentaResponseDto buscarVentaPorId(Long id) {
        return ventaRepository.findById(id)
                .map(VentaMapper::toResponseDto)
                .orElseThrow(() -> new RecursosNoEncontradoException("Venta no encontrada"));
    }
}