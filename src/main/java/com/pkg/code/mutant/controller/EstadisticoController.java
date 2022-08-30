package com.pkg.code.mutant.controller;

import com.pkg.code.mutant.dto.JsonAdnResult;
import com.pkg.code.mutant.service.MutanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stats")
public class EstadisticoController {

    @Autowired
    private MutanteService service;

    @GetMapping()
    public ResponseEntity<JsonAdnResult> estadisticaMutantes() {
        JsonAdnResult  result =  service.resultadoEstadistico();
        return ResponseEntity.ok(result);
    }
}
