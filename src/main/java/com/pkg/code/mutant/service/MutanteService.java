package com.pkg.code.mutant.service;

import com.pkg.code.mutant.dto.JsonAdnResult;
import com.pkg.code.mutant.dto.JsonDNA;
import com.pkg.code.mutant.dto.JsonResult;
import com.pkg.code.mutant.entity.Mutante;
import com.pkg.code.mutant.execption.HandledException;
import com.pkg.code.mutant.interfaz.MutanteInterfaz;
import com.pkg.code.mutant.repository.MutanteRepository;
import com.pkg.code.mutant.util.MutanteUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

@Service
public class MutanteService implements MutanteInterfaz {

    private final Log LOGGER = LogFactory.getLog(this.getClass());

    private static final Pattern NITROGENADA_ADN = Pattern.compile("[atcg]+", Pattern.CASE_INSENSITIVE);

    @Autowired
    private MutanteRepository repository;

    @Override
    public JsonResult validacionAdn (JsonDNA jsonDna) {
        if (jsonDna == null)
            return  new JsonResult(HttpStatus.BAD_REQUEST,"Debe ingresar un Json Valido");

        boolean adnMutante;
        try {
            adnMutante = isDnaMutante(jsonDna);
            //guardar
            //Optional<Mutante> mut = repository.findByMutanteSecuencia(jsonDna.getDna().toString());
            if (!findByAdnMutante(jsonDna.getDna().toString())){
                Mutante mutant = Mutante.builder()
                                        .isMutante(adnMutante)
                                        .fecha(java.sql.Date.valueOf("2017-11-15"))
                                        .secuencia(jsonDna.getDna().toString())
                                        .build();
                repository.save(mutant);
            }
            if (adnMutante){
                return  new JsonResult(HttpStatus.OK,"EL adn ingresado es de un humano mutante");
            }else{
                return  new JsonResult(HttpStatus.OK,"El adn ingresado es de un humano normal");
            }
        }catch (HandledException e){
            return new JsonResult(e.getStatusCode(),e.getMessage());
        }

       // return null;
    }

    @Override
    public JsonAdnResult resultadoEstadistico() {
        int cantidaHumano = 0, cantidadMutante= 0;
        float ratio=0;
        try {
            List<Mutante> lista =  repository.findAll();
            for(Mutante item : lista){
                if (item.getIsMutante()){
                    cantidadMutante++;
                }else{
                    cantidaHumano++;
                }
            }

            if (cantidaHumano != 0){
                ratio = cantidadMutante/cantidaHumano;
            }

            JsonAdnResult result = JsonAdnResult.builder()
                                        .countMutantDna(cantidadMutante)
                                        .countHumanDna(cantidaHumano)
                                        .ratio(ratio).build();

            return result;
        }catch (HandledException e){
            return null;
        }
    }

    @Override
    public List<Mutante> buscarMustantes() {
        return repository.findAll();
    }

    private boolean isDnaMutante(JsonDNA jsonDna) throws HandledException {
        LOGGER.debug("Proceso de validacion ADN Mutante", jsonDna);
        if (jsonDna.getDna().size() <= 4) {
            return false;
        }

        char[][] dna = getArrayStructuraADN(jsonDna);
       MutanteUtil mutanteValidador = new MutanteUtil(dna, 1,4);
       return mutanteValidador.isMutante();

    }
    private char[][] getArrayStructuraADN(JsonDNA jsonDna) throws HandledException {
        int lengthVector = jsonDna.getDna().size();
        char[][] dna = new char[lengthVector][lengthVector];

        for (int i = 0; i < lengthVector; i++) {
            String dnaFila = jsonDna.getDna().get(i);
            if (dnaFila.length() != lengthVector) {
                String msgError = "EL tamaño de la secuencia ADN es diferente a " + lengthVector + ", length "
                        + dnaFila.length();
                throw new HandledException(msgError,HttpStatus.BAD_REQUEST);
            }else if (!NITROGENADA_ADN.matcher(dnaFila).matches()){
                throw new HandledException("El array tiene un caracter no valido",HttpStatus.BAD_REQUEST);
            }

            dna[i] = dnaFila.toUpperCase().toCharArray();
        }
        return dna;
    }

    private boolean findByAdnMutante(String secuencia){
        List<Mutante>  lista  = repository.findAll();
        for (Mutante item: lista){
            if (item.getSecuencia().equals(secuencia)){
                return true;
            }
        }
        return false;
    }
}
