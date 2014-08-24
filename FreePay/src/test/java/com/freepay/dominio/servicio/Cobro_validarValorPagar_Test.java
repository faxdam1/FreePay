package com.freepay.dominio.servicio;

import static org.junit.Assert.*;

import org.junit.Test;

import com.freepay.dominio.modelo.datafono.Cobro;

public class Cobro_validarValorPagar_Test {

	@Test
	public void valor_positivo_valido() {
		int valorPagar = 1000;
		assertNull( Cobro.validarValorPagar(valorPagar) );
	}
	
	@Test
	public void valor_negativo_invalido() {
		int valorPagar = -1000;
		assertNotNull( Cobro.validarValorPagar(valorPagar) );
	}
	
	@Test
	public void valor_0_invalido() {
		int valorPagar = 0;
		assertNotNull( Cobro.validarValorPagar(valorPagar) );
	}
}
