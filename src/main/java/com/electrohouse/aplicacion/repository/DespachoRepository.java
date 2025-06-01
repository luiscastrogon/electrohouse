package com.electrohouse.aplicacion.repository;

import com.electrohouse.aplicacion.model.Despacho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface DespachoRepository extends JpaRepository<Despacho, Integer> {
}
