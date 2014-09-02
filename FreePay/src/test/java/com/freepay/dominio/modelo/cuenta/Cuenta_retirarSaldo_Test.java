package com.freepay.dominio.modelo.cuenta;

import static org.junit.Assert.*;

import org.junit.Test;

public class Cuenta_retirarSaldo_Test {

	@Test
	public void Retirar_Valor_mayor_al_saldo_disponible() {
		long ValorARetirar = 800;
		
		long ValorSaldoActual = 500;
		
		String MensajeError = "No tiene saldo suficiente.";
		
		Cuenta cuenta = new Cuenta();
		
		cuenta.consignarSaldo(ValorSaldoActual);
		
		assertEquals(cuenta.retirarSaldo(ValorARetirar), MensajeError);
		
	}
	
	
	@Test
	public void Retirar_Valor_menor_a_cero_pesos() {
		long ValorARetirar = -100;
		
		long ValorSaldoActual = 500;
		
		String MensajeError = "El valor a retirar debe ser mayor a 0.";
		
		Cuenta cuenta = new Cuenta();
		
		cuenta.consignarSaldo(ValorSaldoActual);
		
		assertEquals(cuenta.retirarSaldo(ValorARetirar), MensajeError);
		
	}
	
	
	@Test
	public void Retirar_correctamente_500_pesos_de_un_saldo_800() {
		long ValorARetirar = 500;
		
		long ValorSaldoActual = 800;
		
		long ValorDespuesDeRetiro = 300;
		
		Cuenta cuenta = new Cuenta();
		
		cuenta.consignarSaldo(ValorSaldoActual);
		
		assertNull(cuenta.retirarSaldo(ValorARetirar));
		
		assertEquals(cuenta.saldo(), ValorDespuesDeRetiro);	
	}
	

}
