package com.electrohouse.aplicacion.repository;

import com.electrohouse.aplicacion.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    //busqueda presonalizada por usuario

    Usuario findByCorreo(String correo);

    //busqueda personalizada por clave

    Usuario findByClave(String clave);

    //busqueda validada para correo
    Optional<Usuario> findBycorreo(String correo);
}
