package com.example.crudGyL.controller;

import com.example.crudGyL.dto.request.ClienteRequestDto;
import com.example.crudGyL.dto.response.ClienteResponseDto;
import com.example.crudGyL.service.ClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
public class ClienteController {
    private final ClienteService clienteService;

    @PostMapping
    public ClienteResponseDto crear(@Valid @RequestBody ClienteRequestDto dto) {
        return clienteService.crear(dto);
    }

    @GetMapping
    public List<ClienteResponseDto> listar() {
        return clienteService.listarTodos();
    }

    @PatchMapping("/{id}/desactivar")
    public void eliminar(@PathVariable Long id) {
        clienteService.eliminar(id);
    }
}