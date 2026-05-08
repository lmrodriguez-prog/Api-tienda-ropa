package com.example.crudGyL.service.impl;

import com.example.crudGyL.dto.request.TipoProductoRequestDto;
import com.example.crudGyL.dto.response.TipoProductoResponseDto;
import com.example.crudGyL.entity.TipoProducto;
import com.example.crudGyL.exception.RecursosNoEncontradoException;
import com.example.crudGyL.mapper.TipoProductoMapper;
import com.example.crudGyL.repository.TipoProductoRepository;
import com.example.crudGyL.service.TipoProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TipoProductoServiceImpl implements TipoProductoService {

    private final TipoProductoRepository repository;

    @Override
    public TipoProductoResponseDto crear(TipoProductoRequestDto dto) {

        TipoProducto tipo = TipoProductoMapper.toEntity(dto);
        return TipoProductoMapper.toResponseDto(repository.save(tipo));
    }

    @Override
    public List<TipoProductoResponseDto> listarTodos() {
        return repository.findAll().stream()
                .map(TipoProductoMapper::toResponseDto)
                .toList();
    }

    @Override
    public TipoProductoResponseDto buscarPorId(Long id) {
        return repository.findById(id)
                .map(TipoProductoMapper::toResponseDto)
                .orElseThrow(() -> new RecursosNoEncontradoException("No se encontró la categoría con ID: " + id));
    }

    @Override
    public void eliminar(Long id) {

    }
}