package com.microservicio.item.microservicioitem.clientes;

import java.util.List;

import com.microservicio.item.microservicioitem.models.Producto;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "servicio-productos")
public interface ProductoClienteRest {
    
    @GetMapping("/listar")
    public List<Producto> listar();

    @GetMapping("/ver/{id}")
    public Producto Ver(@PathVariable Long id);
}