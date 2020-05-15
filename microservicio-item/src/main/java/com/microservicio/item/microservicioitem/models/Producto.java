package com.microservicio.item.microservicioitem.models;

import java.util.Date;

public class Producto {
    private Long id;
    private String nombre;
    private Double precio;
    private Date createAt;

    public Producto(Long id, String nombre, Double precio, Date createAt, Integer port) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.createAt = createAt;
        this.port = port;
    }

    public Integer getPort() {
        return this.port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Producto port(Integer port) {
        this.port = port;
        return this;
    }

    private Integer port;

    public Producto() {
    }

    public Producto(Long id, String nombre, Double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Double getPrecio() {
        return this.precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Date getCreateAt() {
        return this.createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Producto id(Long id) {
        this.id = id;
        return this;
    }
    
    public Producto nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public Producto precio(Double precio) {
        this.precio = precio;
        return this;
    }

    public Producto createAt(Date createAt) {
        this.createAt = createAt;
        return this;
    }

    @Override
    public String toString() {
        return "{" +
        " id='" + getId() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", precio='" + getPrecio() + "'" +
            ", createAt='" + getCreateAt() + "'" +
            "}";
    }
}
    