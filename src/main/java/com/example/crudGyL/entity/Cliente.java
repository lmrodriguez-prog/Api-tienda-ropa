package com.example.crudGyL.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "cliente")
@Data
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;

    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    private String direccion;

    public void setEmail(@NotBlank(message = "El email es obligatorio") @Email(message = "Debe ser un email válido") String email) {
    }

    public String getEmail() {

        String String = "";
        return String;
    }
}

        