package com.microservicio.item.microservicioitem.models.services;

import java.util.List;

import com.microservicio.item.microservicioitem.models.Item;

public interface IItemServices {
    public List<Item> findAll();
    public Item findById(Long id, Integer cantidad);
    public Item save(Item item);
    public Item update(Item item, Long id);
    public void delete(Long id);
}