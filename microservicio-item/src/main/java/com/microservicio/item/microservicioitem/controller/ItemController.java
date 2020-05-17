package com.microservicio.item.microservicioitem.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.microservicio.item.microservicioitem.models.Item;
import com.microservicio.item.microservicioitem.models.Producto;
import com.microservicio.item.microservicioitem.models.services.IItemServices;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class ItemController {
    
    private static Logger log = LoggerFactory.getLogger(ItemController.class);

    @Autowired
    private Environment enviroment;

    @Autowired
    @Qualifier("serviceFeing")
    //@Qualifier("serviceClientRest")
    private IItemServices itemService;

    @Value("${configuration.texto}")
    private String texto;

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

    @GetMapping("/obtener-config")
    public ResponseEntity<?> obtenerConfig(@Value("${server.port}") String puerto){

        log.info(texto);

        Map<String, String> json = new HashMap<>();
        json.put("texto", texto);
        json.put("puerto", puerto);
        
        if (enviroment.getActiveProfiles().length > 0 && enviroment.getActiveProfiles()[0].equals("dev")) {
            json.put("autor.nombre", enviroment.getProperty("configuration.autor.nombre"));
            json.put("autor.email",  enviroment.getProperty("configuration.autor.email"));
        }

        return new ResponseEntity<Map<String, String>>(json, HttpStatus.OK);
    }
}