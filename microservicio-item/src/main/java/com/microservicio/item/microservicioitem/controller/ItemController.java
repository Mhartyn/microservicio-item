package com.microservicio.item.microservicioitem.controller;

import java.util.List;

import com.microservicio.item.microservicioitem.models.Item;
import com.microservicio.item.microservicioitem.models.Producto;
import com.microservicio.item.microservicioitem.models.services.IItemServices;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {
    
    @Autowired
    @Qualifier("serviceFeing")
    //@Qualifier("serviceClientRest")
    private IItemServices itemService;

    @GetMapping("/listar")
    public List<Item> Listar(){
        return itemService.findAll();
    }

    @HystrixCommand(fallbackMethod = "VerPorDefecto")
    @GetMapping("/ver/{id}/{cantidad}")
    public Item Ver(@PathVariable Long id, @PathVariable Integer cantidad){
        return itemService.findById(id, cantidad);
    }

    public Item VerPorDefecto(Long id, Integer cantidad){
        return new Item(new Producto(id, "Sin Descripcion", 0.0), cantidad);
    }
}