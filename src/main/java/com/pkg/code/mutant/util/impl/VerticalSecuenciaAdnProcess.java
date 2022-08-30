package com.pkg.code.mutant.util.impl;

import com.pkg.code.mutant.util.abstracta.DetectarMutanteProcess;

public class VerticalSecuenciaAdnProcess extends DetectarMutanteProcess {

    public VerticalSecuenciaAdnProcess(ContextoMutante contexto) {
        super(contexto);
    }

    @Override
    public void buscarSecuenciaMutante() {
        char[][] dna = contexto.getAdn();
        for (int column = 0; column < dna.length; column++) {
            boolean match = encontrarSecuenciaMutante(Coordinate.at(dna, 0, column));
            if (match) {
                break;
            }
        }
    }

    @Override
    protected void moveNext(Coordinate coordinate) {
        coordinate.row++;
        coordinate.subIndex++;
        coordinate.lastChar = coordinate.curruntChar;
        coordinate.curruntChar = coordinate.dna[coordinate.row][coordinate.column];
    }

    @Override
    protected boolean hasNext(Coordinate coordinate, int actualSequence) {
        return coordinate.row + 1 <= coordinate.safeIndex;
    }
}
