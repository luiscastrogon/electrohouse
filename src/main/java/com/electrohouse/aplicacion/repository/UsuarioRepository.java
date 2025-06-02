package com.electrohouse.aplicacion.repository;

import com.electrohouse.aplicacion.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    //busqueda presonalizada por usuario

    Usuario findByCorreo(String correo);

}
