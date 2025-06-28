package com.shopall.shopall_api.model;


import jakarta.persistence.*;

@Entity
@Table (name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProducto;

    private String nomProducto;
    private String descripcion;
    private Double precio;
    private Integer stock;

    // Constructores, getters y setters

    public Producto(Integer stock, Double precio, String descripcion, String nomProducto, Integer idProducto) {
        this.stock = stock;
        this.precio = precio;
        this.descripcion = descripcion;
        this.nomProducto = nomProducto;
        this.idProducto = idProducto;
    }

    public Producto() {
        // Constructor vacío requerido por JPA
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNomProducto() {
        return nomProducto;
    }

    public void setNomProducto(String nomProducto) {
        this.nomProducto = nomProducto;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
