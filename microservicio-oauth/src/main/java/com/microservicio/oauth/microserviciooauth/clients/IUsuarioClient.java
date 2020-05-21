package com.microservicio.oauth.microserviciooauth.clients;

import com.microservicio.common.usuario.microserviciocommonusuario.models.entity.Usuario;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("servicio-usuarios")
public interface IUsuarioClient {
    
    @GetMapping("/usuarios/search/buscar-username")
    public Usuario findByUsername(@RequestParam String username);
}