package com.pkg.code.mutant.interfaz;

import com.pkg.code.mutant.dto.JsonAdnResult;
import com.pkg.code.mutant.dto.JsonDNA;
import com.pkg.code.mutant.dto.JsonResult;
import com.pkg.code.mutant.entity.Mutante;

import java.util.List;

public interface MutanteInterfaz {
    public JsonResult validacionAdn (JsonDNA jsonDna);
    JsonAdnResult resultadoEstadistico();
    List<Mutante> buscarMustantes();
}
