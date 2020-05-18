package com.microservicio.item.microservicioitem.models.services;

import java.util.List;
import java.util.stream.Collectors;

import com.microservicio.item.microservicioitem.clientes.ProductoClienteRest;
import com.microservicio.item.microservicioitem.models.Item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("serviceFeing")
public class ItemServicesFeing implements IItemServices {

    @Autowired
    private ProductoClienteRest clienteFeing;

    @Override
    public List<Item> findAll() {
        return clienteFeing.listar().stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer cantidad) {        
        return new Item(clienteFeing.ver(id), cantidad);
    }

    @Override
    public Item save(Item item) {
        item.setProducto(clienteFeing.crear(item.getProducto()));
        return item;
    }

    @Override
    public Item update(Item item, Long id) {
        item.setProducto(clienteFeing.update(item.getProducto(), id));
        return item;
    }

    @Override
    public void delete(Long id) {
        clienteFeing.eliminar(id);
    }
    
}