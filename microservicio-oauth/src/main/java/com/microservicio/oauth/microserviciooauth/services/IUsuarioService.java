package com.microservicio.oauth.microserviciooauth.services;

import com.microservicio.common.usuario.microserviciocommonusuario.models.entity.Usuario;

public interface IUsuarioService {
    public Usuario findByUsername(String username);

    public Usuario update(Usuario usuario, Long id);
}