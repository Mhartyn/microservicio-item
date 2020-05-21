package com.microservicio.oauth.microserviciooauth.services;

import java.util.List;
import java.util.stream.Collectors;

import com.microservicio.common.usuario.microserviciocommonusuario.models.entity.Usuario;
import com.microservicio.oauth.microserviciooauth.clients.IUsuarioClient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements UserDetailsService {

    private Logger log = LoggerFactory.getLogger(UsuarioService.class);

    @Autowired
    private IUsuarioClient client;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = client.findByUsername(username);

        if (usuario == null) {
            String error = "Error en el login, no existe usuario " + username;
            log.error(error);
            throw new UsernameNotFoundException(error);
        }

        List<GrantedAuthority> authorities = usuario.getRoles().stream()
                                                    .map(rol -> new SimpleGrantedAuthority(rol.getNombre()))
                                                    .peek(authority -> log.info("Rol: " + authority.getAuthority()))
                                                    .collect(Collectors.toList());
        log.info("Usuario autenticado: " + username);
        return new User(usuario.getUsername(), usuario.getPassword(), usuario.getEnabled(), true, true, true, authorities);
    }
    
}