package com.pkg.code.mutant.util.abstracta;

import com.pkg.code.mutant.util.impl.ContextoMutante;

import java.util.Arrays;

public abstract class DetectarMutanteProcess {

	protected final ContextoMutante contexto;

	public DetectarMutanteProcess(ContextoMutante contexto) {
		this.contexto = contexto;
	}

	public abstract void buscarSecuenciaMutante();
	protected abstract void moveNext(Coordinate coordinate);
	protected abstract boolean hasNext(Coordinate coordinate, int actualSequence);


	protected boolean encontrarSecuenciaMutante(Coordinate coordidate) {
		char currentChar = coordidate.dna[coordidate.row][coordidate.column];
		int sequence = 1;
		while (hasNext(coordidate, sequence)) {
			moveNext(coordidate);
			if (currentChar != coordidate.curruntChar) {
				sequence = 1;
				currentChar = coordidate.curruntChar;
			} else if (++sequence >= contexto.getSecuenciaMutante()) {
				this.newSequenceMatch();
				if (hasMatchSequencesMutant()) {
					return Boolean.TRUE;
				}
			}
		}
		return Boolean.FALSE;
	}

	protected void newSequenceMatch() {
		contexto.setMatchs(contexto.getMatchs() + 1);

	}

	public boolean hasMatchSequencesMutant() {
		int count = contexto.getCantidadSecuenciaMutante();
		return contexto.getMatchs() >= count;
	}

	protected static class Coordinate {
		public char dna[][];
		public int subIndex;
		public int row;
		public int column;
		public char lastChar;
		public char curruntChar;
		public int safeIndex;
		public int size;

		public Coordinate(char[][] dna, int subIndex, int row, int column) {
			super();
			this.dna = dna;
			this.safeIndex = dna.length - 1;
			this.size = dna.length;
			this.subIndex = subIndex;
			this.row = row;
			this.column = column;
			this.lastChar = dna[row][column];
		}

		@Override
		public String toString() {
			return "Coordinate{" +
					"dna=" + Arrays.toString(dna) +
					", subIndex=" + subIndex +
					", row=" + row +
					", column=" + column +
					", lastChar=" + lastChar +
					", curruntChar=" + curruntChar +
					", safeIndex=" + safeIndex +
					", size=" + size +
					'}';
		}

		public static Coordinate at(char[][] dna, int row, int column) {
			return new Coordinate(dna, 0, row, column);
		}

		public static Coordinate at(char[][] dna, int row, int column, int index) {
			return new Coordinate(dna, index, row, column);
		}

	}

}
