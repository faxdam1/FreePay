package com.freepay.dominio.modelo.cuenta;

import static org.junit.Assert.*;

import org.junit.Test;

public class Cuenta_consignarSaldo_Test {

	@Test
	public void Consignar_500_pesos_exitosamente() {
		long ValorAConsingar = 500;
		
		Cuenta cuenta = new Cuenta();
		
		assertNull(cuenta.consignarSaldo(ValorAConsingar));
		
		assertEquals(ValorAConsingar, cuenta.saldo);
		
	}
	
	@Test
	public void Consignar_menos_500_pesos() {
		long ValorAConsingar = -500;
		String MensajeError = "El valor a consignar debe ser mayor a 0.";
		
		Cuenta cuenta = new Cuenta();
		
		assertEquals(cuenta.consignarSaldo(ValorAConsingar), MensajeError);
		
	}

	@Test
	public void Consignar_0_pesos() {
		long ValorAConsingar = 0;
		String MensajeError = "El valor a consignar debe ser mayor a 0.";
		
		Cuenta cuenta = new Cuenta();
		
		assertEquals(cuenta.consignarSaldo(ValorAConsingar), MensajeError);
		
	}
	
}
