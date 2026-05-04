package com.example.crudGyL.entity;


import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Table(name = "tipo_producto")
@Data
public class TipoProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipoProducto;

    private String nombre;
    private String descripcion;

    @OneToMany(mappedBy = "tipoProducto")
    private List<Producto> productos;
}
