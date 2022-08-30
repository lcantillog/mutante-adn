package com.pkg.code.mutant.util.impl;

import com.pkg.code.mutant.util.abstracta.DetectarMutanteProcess;

public class DiagonalInversaSecuenciaProcess  extends DetectarMutanteProcess {

    public DiagonalInversaSecuenciaProcess(ContextoMutante contexto) {
        super(contexto);
    }

    @Override
    public void buscarSecuenciaMutante() {
        char[][] dna = contexto.getAdn();

        int fistIndexRow = dna.length - 1;
        int fistIndexColumn = 0;
        boolean match = encontrarSecuenciaMutante(Coordinate.at(dna, fistIndexRow, fistIndexColumn));
        if (match) {
            return;
        }
        for (int row = 1; row <= dna.length - contexto.getSecuenciaMutante(); row++) {
            match = encontrarSecuenciaMutante(Coordinate.at(dna, fistIndexRow - row, 0, row))
                    || encontrarSecuenciaMutante(Coordinate.at(dna, fistIndexRow, row, row));
            if (match) {
                break;
            }
        }

    }

    @Override
    protected void moveNext(Coordinate coordinate) {
        coordinate.row--;
        coordinate.column++;
        coordinate.subIndex++;
        coordinate.lastChar = coordinate.curruntChar;
        coordinate.curruntChar = coordinate.dna[coordinate.row][coordinate.column];
    }

    @Override
    protected boolean hasNext(Coordinate coordinate, int actualSequence) {
        int index = coordinate.subIndex;
        int available = coordinate.size - index;
        return available + actualSequence >= contexto.getSecuenciaMutante() && coordinate.row - 1 >= 0;
    }

}
