package com.pkg.code.mutant.util.impl;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter @Setter
public class ContextoMutante {

	char[][] adn;
	private int secuenciaMutante;
	private int cantidadSecuenciaMutante;
	private int matchs;
}
