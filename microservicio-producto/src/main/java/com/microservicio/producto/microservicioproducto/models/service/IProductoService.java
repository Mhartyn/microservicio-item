package com.microservicio.producto.microservicioproducto.models.service;

import java.util.List;

import com.microservicio.producto.microservicioproducto.models.entity.Producto;

public interface IProductoService {

    public List<Producto> findAll();
    public Producto findById(long id);
    public Producto save(Producto producto);
    public void delteById(Long id);
}