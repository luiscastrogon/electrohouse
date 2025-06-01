package com.electrohouse.aplicacion.controller;

import com.electrohouse.aplicacion.model.Documento;
import com.electrohouse.aplicacion.service.DocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class DocumentoController {
    @Autowired
    private DocumentoService documentoService;

    @GetMapping("/api/v1/documento")
    public ResponseEntity<?> getDocumentos() {
        List<Documento> documentos = documentoService.findAll();
        return ResponseEntity.status(200).body(documentos);
    }

}
