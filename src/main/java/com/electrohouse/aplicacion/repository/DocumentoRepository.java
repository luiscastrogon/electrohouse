package com.electrohouse.aplicacion.repository;

import com.electrohouse.aplicacion.model.Documento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface DocumentoRepository extends JpaRepository<Documento, Integer> {
}
