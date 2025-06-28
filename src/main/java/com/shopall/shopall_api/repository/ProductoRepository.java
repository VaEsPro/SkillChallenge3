package com.shopall.shopall_api.repository;

import com.shopall.shopall_api.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    List<Producto> findByNomProductoContaining(String nomProducto);
}
