package com.microservicio.item.microservicioitem.models;

public class Item {
    private Producto producto;
    private Integer cantidad;

    public Item() {
    }

    public Item(Producto producto, Integer cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return this.producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Item producto(Producto producto) {
        this.producto = producto;
        return this;
    }

    public Item cantidad(Integer cantidad) {
        this.cantidad = cantidad;
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " producto='" + getProducto() + "'" +
            ", cantidad='" + getCantidad() + "'" +
            "}";
    }

    public Double getTotal(){
        return producto.getPrecio() * cantidad.doubleValue();
    }
}