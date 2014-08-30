package com.freepay.dominio.servicio;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.freepay.dominio.excepciones.ExcepcionNegocio;
import com.freepay.dominio.modelo.datafono.Cobro;
import com.freepay.dominio.modelo.datafono.IDatafonoRepository;

public class DatafonoService_generarCobro_Test {
	
	@Mock
	private IDatafonoRepository datafonoRepositoryMock;
	
	@Before
	public void runBeforeTest() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void generar_cobro_exitoso() throws ExcepcionNegocio, Exception {
		int codigoDatafono = 1;
		String referencia = "cuenta de cobro";
		int valorPagar = 10000;
		
		DatafonoService datafonoService = new DatafonoService();
		datafonoService.setDatafonoRepository(datafonoRepositoryMock);
		
		Mockito.doNothing().when(datafonoRepositoryMock).guardarCobro( Mockito.any(Cobro.class) );
		
		Cobro cobro = datafonoService.generarCobro(codigoDatafono, referencia, valorPagar);
		
		assertNotNull(cobro);
		assertEquals(codigoDatafono, cobro.codigoDatafono());
		assertEquals(referencia, cobro.referencia());
		assertEquals(valorPagar, cobro.valorPagar());
		assertTrue(cobro.codigo() >= 0);
	}
	
	@Test
	public void valor_pagar_negativo_genera_excepcion_negocio() throws ExcepcionNegocio, Exception {
		boolean condicion = false;
		
		int codigoDatafono = 1;
		String referencia = "cuenta de cobro";
		int valorPagar = -10000;
		
		DatafonoService datafonoService = new DatafonoService();
		datafonoService.setDatafonoRepository(datafonoRepositoryMock);
		
		Mockito.doNothing().when(datafonoRepositoryMock).guardarCobro( Mockito.any(Cobro.class) );
		
		try {
			datafonoService.generarCobro(codigoDatafono, referencia, valorPagar);
		} catch(ExcepcionNegocio en) {
			condicion = true;
		}
		
		assertTrue(condicion);
	}
	
	@Test
	public void valor_pagar_0_genera_excepcion_negocio() throws ExcepcionNegocio, Exception {
		boolean condicion = false;
		
		int codigoDatafono = 1;
		String referencia = "cuenta de cobro";
		int valorPagar = 0;
		
		DatafonoService datafonoService = new DatafonoService();
		datafonoService.setDatafonoRepository(datafonoRepositoryMock);
		
		Mockito.doNothing().when(datafonoRepositoryMock).guardarCobro( Mockito.any(Cobro.class) );
		
		try {
			datafonoService.generarCobro(codigoDatafono, referencia, valorPagar);
		} catch(ExcepcionNegocio en) {
			condicion = true;
		}
		
		assertTrue(condicion);
	}
	
	@Test
	public void valor_error_guardando_cobro_genera_excepcion() throws ExcepcionNegocio, Exception {
		boolean condicion = false;
		
		int codigoDatafono = 1;
		String referencia = "cuenta de cobro";
		int valorPagar = 10000;
		
		DatafonoService datafonoService = new DatafonoService();
		datafonoService.setDatafonoRepository(datafonoRepositoryMock);
		
		Mockito.doThrow(Exception.class).when(datafonoRepositoryMock).guardarCobro( Mockito.any(Cobro.class) );
		
		try {
			datafonoService.generarCobro(codigoDatafono, referencia, valorPagar);
		} catch(Exception e) {
			condicion = true;
		}
		
		assertTrue(condicion);
	}
}
