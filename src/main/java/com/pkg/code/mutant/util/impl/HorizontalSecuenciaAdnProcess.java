package com.pkg.code.mutant.util.impl;

import com.pkg.code.mutant.util.abstracta.DetectarMutanteProcess;

public class HorizontalSecuenciaAdnProcess extends DetectarMutanteProcess {

    public HorizontalSecuenciaAdnProcess(ContextoMutante contexto) {
        super(contexto);
    }

    @Override
    public void buscarSecuenciaMutante() {
      //  log.debug("Analyze colums of given dna sequence at direction {}: ", DIRECTION);
        char[][] dna = contexto.getAdn();
        for (int row = 0; row < dna.length; row++) {
            boolean match = encontrarSecuenciaMutante(Coordinate.at(dna, row, 0));
            if (match) {
                break;
            }
        }
    }

    @Override
    protected void moveNext(Coordinate coordinate) {
        coordinate.column++;
        coordinate.subIndex++;
        coordinate.lastChar = coordinate.curruntChar;
        coordinate.curruntChar = coordinate.dna[coordinate.row][coordinate.column];
    }

    @Override
    protected boolean hasNext(Coordinate coordinate, int actualSequence) {
        return coordinate.column + 1 <= coordinate.safeIndex;
    }
}
