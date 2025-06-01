package com.electrohouse.aplicacion.service;

import com.electrohouse.aplicacion.model.Despacho;
import com.electrohouse.aplicacion.repository.DespachoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional

public class DespachoService {

    @Autowired
    private DespachoRepository despachoRepository;

    public List<Despacho> findAll() {
        return despachoRepository.findAll();
    }
}
