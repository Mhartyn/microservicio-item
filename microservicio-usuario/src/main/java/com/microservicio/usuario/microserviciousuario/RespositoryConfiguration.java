package com.microservicio.usuario.microserviciousuario;


import com.microservicio.common.usuario.microserviciocommonusuario.models.entity.Rol;
import com.microservicio.common.usuario.microserviciocommonusuario.models.entity.Usuario;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

@EntityScan({"com.microservicio.common.usuario.microserviciocommonusuario.models.entity"})
@Configuration
public class RespositoryConfiguration implements RepositoryRestConfigurer {
    
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config){
        config.exposeIdsFor(Usuario.class, Rol.class);
    }
}