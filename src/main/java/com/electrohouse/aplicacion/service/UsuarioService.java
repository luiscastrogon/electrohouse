package com.electrohouse.aplicacion.service;

import com.electrohouse.aplicacion.model.Usuario;
import com.electrohouse.aplicacion.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    //Regla para guardar usarios.

    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    //Regla para buscar usuarios.

    public Usuario findBycorreo(String correo) {
        return usuarioRepository.findByCorreo(correo);
    }

    public Usuario findByclave(String clave) {
        return usuarioRepository.findByClave(clave);
    }

    //regla de login usuario.

    public Optional<Usuario> login(String correo, String clave) {
        Optional<Usuario> usuarioLog = usuarioRepository.findBycorreo(correo);
        if (usuarioLog.isPresent() && usuarioLog.get().getClave().equals(clave)) {
            return usuarioLog;
        }
        return Optional.empty();
    }

    //regla para cambiar contraseña de login.

    public boolean changePassword(String correo, String nuevaClave) {
        Optional<Usuario> usuarioLog = usuarioRepository.findBycorreo(correo);
        if (usuarioLog.isPresent()){
            Usuario usuario = usuarioLog.get();
            usuario.setClave(nuevaClave);
            usuarioRepository.save(usuario);
            return true;
        }
        return false;
    }
}
