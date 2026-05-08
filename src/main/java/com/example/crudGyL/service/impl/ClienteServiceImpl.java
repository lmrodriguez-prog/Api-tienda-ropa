package com.example.crudGyL.service.impl;

import com.example.crudGyL.dto.request.ClienteRequestDto;
import com.example.crudGyL.dto.response.ClienteResponseDto;
import com.example.crudGyL.entity.Cliente;
import com.example.crudGyL.exception.RecursosNoEncontradoException;
import com.example.crudGyL.mapper.ClienteMapper;
import com.example.crudGyL.repository.ClienteRepository;
import com.example.crudGyL.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Override
    public ClienteResponseDto crear(ClienteRequestDto dto) {
        Cliente cliente = ClienteMapper.toEntity(dto);
        return ClienteMapper.toResponseDto(clienteRepository.save(cliente));
    }

    @Override
    public List<ClienteResponseDto> listarTodos() {
        return clienteRepository.findAll().stream()
                .map(ClienteMapper::toResponseDto)
                .toList();
    }

    @Override
    public ClienteResponseDto buscarPorId(Long id) {
        return clienteRepository.findById(id)
                .map(ClienteMapper::toResponseDto)
                .orElseThrow(() -> new RecursosNoEncontradoException("Cliente no encontrado con ID: " + id));
    }

    @Override
    public void eliminar(Long id) {
        if (!clienteRepository.existsById(id)) {
            throw new RecursosNoEncontradoException("No se puede eliminar: Cliente no existe");
        }
        clienteRepository.deleteById(id);
    }
}
