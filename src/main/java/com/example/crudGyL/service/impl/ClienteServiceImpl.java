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
        cliente.setEstadoCliente(true);
        return ClienteMapper.toResponseDto(clienteRepository.save(cliente));
    }

    // Lógica para put
    @Override
    public ClienteResponseDto actualizar(Long id, ClienteRequestDto dto) {
        Cliente clienteExistente = clienteRepository.findById(id)
                .orElseThrow(() -> new RecursosNoEncontradoException("No existe el cliente con ID: " + id));

        // Actualizo datos usando DTO
        clienteExistente.setNombre(dto.nombre());
        clienteExistente.setApellido(dto.apellido());
        clienteExistente.setCorreo(dto.email());
        clienteExistente.setTelefono(dto.telefono());
        clienteExistente.setDireccion(dto.direccion());

        return ClienteMapper.toResponseDto(clienteRepository.save(clienteExistente));
    }


    @Override
    public void bajaLogica(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RecursosNoEncontradoException("ID no encontrado para dar de baja"));

        cliente.setEstadoCliente(false); // Solo apagamos el estado
        clienteRepository.save(cliente);
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

    @Override
    public ClienteResponseDto actualizar(Long id) {
        return null;
    }
}
