package com.shopall.shopall_api.controller;


import com.shopall.shopall_api.model.Producto;
import com.shopall.shopall_api.service.ProductoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RestController combina @Controller + @ResponseBody

@RequestMapping("/api/productos")
public class ProductoController {
    private final ProductoService service;

    public ProductoController(ProductoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Producto> crear(@RequestBody Producto p){
        Producto guardado = service.crear(p);
        return ResponseEntity.ok(guardado);
    }

    @GetMapping
    public ResponseEntity<List<Producto>> listar(){
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{idProducto}")
    public ResponseEntity<Producto> obtener(@PathVariable Integer idProducto){
        return service.buscarPorId(idProducto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{idProducto}")
    public ResponseEntity<Producto> actualizar(@PathVariable Integer idProducto, @RequestBody Producto p){
        try {
            return ResponseEntity.ok(service.actualizar(idProducto, p));
        } catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{idProducto}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer idProducto){
        service.eliminar(idProducto);
        return ResponseEntity.noContent().build();
    }

    // Cada método está mapeado a una ruta y verbo HTTP
}
