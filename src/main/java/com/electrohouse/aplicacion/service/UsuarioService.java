package com.electrohouse.aplicacion.service;

import com.electrohouse.aplicacion.model.Usuario;
import com.electrohouse.aplicacion.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional

public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario findBycorreo(String correo) {
        return usuarioRepository.findByCorreo(correo);
    }
}
