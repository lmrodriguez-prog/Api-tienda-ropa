package com.example.crudGyL.repository;

import com.example.crudGyL.entity.Producto;
import com.example.crudGyL.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {


    List<Producto> findByNombre(String nombre);
    List<Producto> findByStock(Integer stock);


    void delete(Producto producto);
}
