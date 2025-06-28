package com.shopall.shopall_api.service;

import com.shopall.shopall_api.model.Producto;
import com.shopall.shopall_api.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {
    private final ProductoRepository repo;

    public ProductoService(ProductoRepository repo) {
        this.repo = repo;
    }

    public Producto crear(Producto p){
        return repo.save(p);
    }

    public List<Producto> listar(){
        return repo.findAll();
    }

    public Optional<Producto> buscarPorId(Integer idProducto){
        return repo.findById(idProducto);
    }

    public Producto actualizar(Integer idProducto, Producto datos){
        return repo.findById(idProducto).map(p -> {
            p.setNomProducto(datos.getNomProducto());
            p.setDescripcion(datos.getDescripcion());
            p.setPrecio(datos.getPrecio());
            p.setStock(datos.getStock());
            return repo.save(p);
        }).orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    public void eliminar(Integer idProducto){
        repo.deleteById(idProducto);
    }
}
