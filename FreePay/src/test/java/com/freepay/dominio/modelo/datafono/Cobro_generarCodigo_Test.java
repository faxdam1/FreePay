package com.freepay.dominio.modelo.datafono;

import static org.junit.Assert.*;

import org.junit.Test;

public class Cobro_generarCodigo_Test {

	@Test
	public void codigo_generado_positivo() {
		int codigoDatafono = 1;
		String referencia = "cuenta de cobro";
		int valorPagar = 10000;
		
		Cobro cobro = new Cobro(codigoDatafono, referencia, valorPagar);
		
		assertTrue(cobro.codigo() >= 0);
	}
	
	@Test
	public void codigo_generado_cobro1_diferente_cobro2() {
		int codigoDatafono = 1;
		String referencia = "cuenta de cobro";
		int valorPagar = 10000;
		
		Cobro cobro1 = new Cobro(codigoDatafono, referencia, valorPagar);
		
		Cobro cobro2 = new Cobro(codigoDatafono, referencia, valorPagar);
		
		assertTrue(cobro1.codigo() != cobro2.codigo());
	}
}
