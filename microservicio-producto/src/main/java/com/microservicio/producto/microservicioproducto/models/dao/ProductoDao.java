package com.microservicio.producto.microservicioproducto.models.dao;


import com.microservicio.common.microserviciocommon.models.entity.Producto;

import org.springframework.data.repository.CrudRepository;

public interface ProductoDao extends CrudRepository<Producto, Long> {
    
}