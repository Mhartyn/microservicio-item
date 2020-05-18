package com.microservicio.item.microservicioitem.models.services;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.microservicio.item.microservicioitem.models.Item;
import com.microservicio.common.microserviciocommon.models.entity.Producto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("serviceClientRest")
public class ItemServices implements IItemServices {
   
    @Autowired
    private RestTemplate clienteRest;

    private String urlBase = "http://servicio-productos";

    @Override
    public List<Item> findAll() {
        String url = urlBase + "/listar";
        List<Producto> productos = Arrays.asList(clienteRest.getForObject(url, Producto[].class));        
        return productos.stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
    }
    
    @Override
    public Item findById(Long id, Integer cantidad) {
        String url = urlBase + "/ver/{id}";
        
        Map<String, String> pathVariables = new HashMap<String, String>();
        pathVariables.put("id", id.toString());
        
        Producto producto = clienteRest.getForObject(url, Producto.class, pathVariables);
        return new Item(producto, cantidad);        
    }

    @Override
    public Item save(Item item){
        String url = urlBase + "/crear";

        HttpEntity<Producto> body = new HttpEntity<Producto>(item.getProducto());        
        ResponseEntity<Producto> response = clienteRest.exchange(url, HttpMethod.POST, body, Producto.class);
        Producto productoResponse = response.getBody();
        
        item.setProducto(productoResponse);        
        return item;
    }
    
    @Override
    public Item update(Item item, Long id) {
        String url = urlBase + "/editar/{id}";
        Map<String, String> pathVariables = new HashMap<String, String>();
        pathVariables.put("id", id.toString());

        HttpEntity<Producto> body = new HttpEntity<Producto>(item.getProducto());
        ResponseEntity<Producto> response = clienteRest.exchange(url, HttpMethod.PUT, body, Producto.class, pathVariables);
        Producto productoResponse = response.getBody();        
        item.setProducto(productoResponse);

        return item;
    }

    @Override
    public void delete(Long id) {
        String url = urlBase + "/eliminar/{id}";
        Map<String, String> pathVariables = new HashMap<String, String>();
        pathVariables.put("id", id.toString());

        clienteRest.delete(url, pathVariables);
    }
    
}