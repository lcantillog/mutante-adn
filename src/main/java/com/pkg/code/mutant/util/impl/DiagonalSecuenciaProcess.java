package com.pkg.code.mutant.util.impl;


import com.pkg.code.mutant.util.abstracta.DetectarMutanteProcess;

public class DiagonalSecuenciaProcess extends DetectarMutanteProcess {

    public DiagonalSecuenciaProcess(ContextoMutante contexto) {
        super(contexto);
    }

    @Override
    public void buscarSecuenciaMutante() {
        char[][] dna = contexto.getAdn();

        boolean match = encontrarSecuenciaMutante(Coordinate.at(dna, 0, 0));
        if (match) {
            return;
        }
        for (int row = 1; row <= dna.length - contexto.getSecuenciaMutante(); row++) {
            match = encontrarSecuenciaMutante(Coordinate.at(dna, row, 0, row))
                    || encontrarSecuenciaMutante(Coordinate.at(dna, 0, row, row));
            if (match) {
                break;
            }
        }
    }

    @Override
    protected void moveNext(Coordinate coordinate) {
        coordinate.row++;
        coordinate.column++;
        coordinate.subIndex++;
        coordinate.lastChar = coordinate.curruntChar;
        coordinate.curruntChar = coordinate.dna[coordinate.row][coordinate.column];

    }

    @Override
    protected boolean hasNext(Coordinate coordinate, int actualSequence) {
        int subIndex = coordinate.subIndex;
        int available = coordinate.size - subIndex;
        return available + actualSequence >= contexto.getSecuenciaMutante()
                && Math.max(coordinate.column, coordinate.row) + 1 < coordinate.size;
    }
}
