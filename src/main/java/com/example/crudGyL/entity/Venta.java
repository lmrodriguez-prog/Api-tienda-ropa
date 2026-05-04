package com.example.crudGyL.entity;


import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "venta")
@Data
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVenta;

    private LocalDate fechaVenta;
    private Double total;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
}
