package com.example.crudGyL.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "producto")
@Data
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducto;

    private String nombre;
    private Double precio;
    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "id_tipo_producto")
    private TipoProducto tipoProducto;
}