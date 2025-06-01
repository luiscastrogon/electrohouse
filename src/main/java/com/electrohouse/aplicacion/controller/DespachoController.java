package com.electrohouse.aplicacion.controller;

import com.electrohouse.aplicacion.model.Despacho;
import com.electrohouse.aplicacion.service.DespachoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class DespachoController {
    @Autowired
    private DespachoService despachoService;

    @GetMapping("/api/v1/despacho")
    public ResponseEntity<?> getDespacho() {
        List<Despacho> despachos = despachoService.findAll();
        return ResponseEntity.status(200).body(despachos);
    }


}
