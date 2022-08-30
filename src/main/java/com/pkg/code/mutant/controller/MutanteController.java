package com.pkg.code.mutant.controller;

import com.pkg.code.mutant.dto.JsonAdnResult;
import com.pkg.code.mutant.dto.JsonDNA;
import com.pkg.code.mutant.dto.JsonResult;
import com.pkg.code.mutant.entity.Mutante;
import com.pkg.code.mutant.service.MutanteService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mutant")
public class MutanteController {

    @Autowired
    private MutanteService service;

    private final Log LOGGER = LogFactory.getLog(this.getClass());

    @PostMapping("/")
    public ResponseEntity<JsonResult> isMutant(@RequestBody JsonDNA jsonDna) {
        LOGGER.debug("post para desctetar si es adn Humano o Mutante: {}", jsonDna);
        JsonResult result = service.validacionAdn(jsonDna);
        return ResponseEntity.status(result.getStatus()).body(result);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Mutante>> estadisticaMutantes() {
        List<Mutante> list =  service.buscarMustantes();
        return ResponseEntity.ok(list);
    }
}
