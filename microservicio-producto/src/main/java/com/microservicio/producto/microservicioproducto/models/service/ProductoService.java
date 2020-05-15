package com.microservicio.producto.microservicioproducto.models.service;

import java.util.List;

import com.microservicio.producto.microservicioproducto.models.dao.ProductoDao;
import com.microservicio.producto.microservicioproducto.models.entity.Producto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private ProductoDao productoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Producto> findAll() {
        return (List<Producto>) productoDao.findAll();
    }

    @Override
    public Producto findById(long id) {
        return productoDao.findById(id).orElse(null);
    }
    
}