package com.pkg.code.mutant.util;

import com.pkg.code.mutant.util.abstracta.DetectarMutanteProcess;
import com.pkg.code.mutant.util.impl.*;

import java.util.LinkedList;
import java.util.List;


public class MutanteUtil {

	private ContextoMutante contexto;
	List<DetectarMutanteProcess> process = new LinkedList<>();

	public MutanteUtil(char[][] dna, int cantidadSecuenciaMutante, int secuenciaMutante) {
		contexto = ContextoMutante.builder().adn(dna)
										.secuenciaMutante(secuenciaMutante)
										.cantidadSecuenciaMutante(cantidadSecuenciaMutante).build();

		loadProceso();
	}

	private void registerProcessor(DetectarMutanteProcess processor) {
		process.add(processor);
	}

	private void loadProceso() {
		DetectarMutanteProcess horizontal = new HorizontalSecuenciaAdnProcess(contexto);
		registerProcessor(horizontal);
		DetectarMutanteProcess vertical = new VerticalSecuenciaAdnProcess(contexto);
		registerProcessor(vertical);
		DetectarMutanteProcess diagnonal = new DiagonalSecuenciaProcess(contexto);
		registerProcessor(diagnonal);
		DetectarMutanteProcess diagnonalInversa = new DiagonalInversaSecuenciaProcess(contexto);
		registerProcessor(diagnonalInversa);
	}

	public boolean isMutante() {
		for (DetectarMutanteProcess item : process) {
			item.buscarSecuenciaMutante();
			if (item.hasMatchSequencesMutant()) {
				break;
			}
		}
		return contexto.getMatchs() >= contexto.getCantidadSecuenciaMutante();
	}

}
