package com.microservicio.producto.microservicioproducto.controllers;

import java.util.List;
import java.util.stream.Collectors;

import com.microservicio.producto.microservicioproducto.models.entity.Producto;
import com.microservicio.producto.microservicioproducto.models.service.IProductoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductoController {

    // @Autowired
    // private Environment environment;

    @Value("${server.port}")
    private Integer port;

    @Autowired
    private IProductoService productoService;

    @GetMapping("/listar")
    public List<Producto> Listar() {
        return productoService.findAll().stream().map(producto -> {
            // producto.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
            producto.setPort(port);
            return producto;
        }).collect(Collectors.toList());
    }

    @GetMapping("/ver/{id}")
    public Producto Ver(@PathVariable Long id) {
        Producto producto = productoService.findById(id);
        // producto.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
        producto.setPort(port);

        /* try {
            Thread.sleep(2000l);
        } catch (InterruptedException e) {            
            e.printStackTrace();
        } */
        return producto;
    }
}