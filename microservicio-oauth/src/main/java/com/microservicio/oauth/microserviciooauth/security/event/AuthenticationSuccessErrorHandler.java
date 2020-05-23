package com.microservicio.oauth.microserviciooauth.security.event;

import com.microservicio.common.usuario.microserviciocommonusuario.models.entity.Usuario;
import com.microservicio.oauth.microserviciooauth.services.IUsuarioService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationEventPublisher;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import feign.FeignException;

@Component
public class AuthenticationSuccessErrorHandler implements AuthenticationEventPublisher {

    private Logger log = LoggerFactory.getLogger(AuthenticationSuccessErrorHandler.class);

    @Autowired
    private IUsuarioService usuarioService;

    @Override
    public void publishAuthenticationSuccess(Authentication authentication) {
        UserDetails user = (UserDetails)authentication.getPrincipal();
        String mensaje = "suscess login: " + user.getUsername();
        System.out.println(mensaje);
        log.info(mensaje);

        Usuario usuario = usuarioService.findByUsername(authentication.getName());
        if (usuario.getIntentos() != null && usuario.getIntentos() > 0) {
            usuario.setIntentos(0);
            usuarioService.update(usuario, usuario.getId());            
        }
    }

    @Override
    public void publishAuthenticationFailure(AuthenticationException exception, Authentication authentication) {
        String mensaje = "suscess login: " + exception.getMessage();
        System.out.println(mensaje);
        log.info(mensaje);

        try {
            Usuario usuario = usuarioService.findByUsername(authentication.getName());
            if (usuario.getIntentos()==null) {
                usuario.setIntentos(0);
            }
            
            log.info("Intentos actual es de: " + usuario.getIntentos());
            usuario.setIntentos(usuario.getIntentos() + 1);
            log.info("Intentos después es de: " + usuario.getIntentos());

            if (usuario.getIntentos() >= 3) {
                log.error(String.format("el usuario %s des-habilitado por maximo de intentos", authentication.getName()));

                usuario.setEnabled(false);
            }

            usuarioService.update(usuario, usuario.getId());
        } catch (FeignException e) {
            log.error(String.format("el usuario %s no existe en el sistema", authentication.getName()));
        }       
    }
    
}