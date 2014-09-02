package com.freepay.dominio.servicio;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.freepay.dominio.excepciones.ExcepcionNegocio;
import com.freepay.dominio.modelo.cuenta.Cuenta;
import com.freepay.dominio.modelo.cuenta.ICuentaRepository;
import com.freepay.dominio.modelo.datafono.Cobro;
import com.freepay.dominio.modelo.datafono.IDatafonoRepository;
import com.freepay.dominio.modelo.transaccion.ITransaccionRepository;
import com.freepay.dominio.modelo.transaccion.TipoTransaccion;
import com.freepay.dominio.modelo.transaccion.Transaccion;
import com.freepay.dominio.modelo.usuario.TipoIdentificacion;
import com.freepay.dominio.modelo.usuario.Usuario;

public class TransaccionService_procesarPago_Test {

	@Mock 
	private IDatafonoRepository datafonoRepositoryMock;
	@Mock
	private ICuentaRepository cuentaRepositoryMock;
	@Mock
	private ITransaccionRepository transaccionRepositoryMock;
	
	@Before
	public void runBeforeTest() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void procesar_pago_exitoso() throws ExcepcionNegocio, Exception {
	
		int codigoCobro = 1;
		int codigoCuenta = 1;
		
		TransaccionService transaccionService = new TransaccionService();
		
		transaccionService.setCuentaRepository(cuentaRepositoryMock);
		transaccionService.setDatafonoRepository(datafonoRepositoryMock);
		transaccionService.setTransaccionRepository(transaccionRepositoryMock);
		
		Cobro cobro = new Cobro(1,"FAC01",100);
		
		Mockito.doReturn(cobro).when(datafonoRepositoryMock).consultarCobro(codigoCobro);
		
		TipoIdentificacion tipoIdentificacion1 = new TipoIdentificacion();
		
		Usuario usuario = new Usuario(1,tipoIdentificacion1,"Tester","Tester");
		
		Cuenta cuenta = new Cuenta(1000,usuario);
		
		Mockito.doReturn(cuenta).when(cuentaRepositoryMock).consultarCuenta(codigoCuenta);
		
		TipoIdentificacion tipoIdentificacion2 = new TipoIdentificacion();
		
		Usuario usuario2 = new Usuario(2,tipoIdentificacion2,"Tester2","Tester2");
		
		Cuenta cuentaReferencia = new Cuenta(2000,usuario2);
		
		Mockito.doReturn(cuentaReferencia).when(cuentaRepositoryMock).consultarCuentaReferencia(cobro.codigoDatafono());
		
		TipoTransaccion tipoTransaccion = new TipoTransaccion(TransaccionService.TRANSACCION_COMPRA, "COMPRA");
		
		Mockito.doReturn(tipoTransaccion).when(transaccionRepositoryMock).consultarTipoTransaccion(TransaccionService.TRANSACCION_COMPRA);
		
		TipoTransaccion tipoTransaccion2 = new TipoTransaccion(TransaccionService.TRANSACCION_VENTA, "VENTA");
		
		Mockito.doReturn(tipoTransaccion2).when(transaccionRepositoryMock).consultarTipoTransaccion(TransaccionService.TRANSACCION_VENTA);
		
		Mockito.doNothing().when(transaccionRepositoryMock).procesarPago(Mockito.eq(cuenta), Mockito.eq(cuentaReferencia), Mockito.any(Transaccion.class), Mockito.any(Transaccion.class), Mockito.eq(cobro));
		
		String mensajeEsperado= "Saldo actual: 900";
		
		assertEquals(mensajeEsperado, transaccionService.procesarPago(codigoCobro, codigoCuenta));
		
	
	}

	@Test
	public void procesar_pago_no_exitoso() throws ExcepcionNegocio, Exception {
	
		int codigoCobro = 1;
		int codigoCuenta = 1;
		
		TransaccionService transaccionService = new TransaccionService();
		
		transaccionService.setCuentaRepository(cuentaRepositoryMock);
		transaccionService.setDatafonoRepository(datafonoRepositoryMock);
		transaccionService.setTransaccionRepository(transaccionRepositoryMock);
		
		Cobro cobro = new Cobro(1,"FAC01",10000);
		
		Mockito.doReturn(cobro).when(datafonoRepositoryMock).consultarCobro(codigoCobro);
		
		TipoIdentificacion tipoIdentificacion1 = new TipoIdentificacion();
		
		Usuario usuario = new Usuario(1,tipoIdentificacion1,"Tester","Tester");
		
		Cuenta cuenta = new Cuenta(1000,usuario);
		
		Mockito.doReturn(cuenta).when(cuentaRepositoryMock).consultarCuenta(codigoCuenta);
		
		TipoIdentificacion tipoIdentificacion2 = new TipoIdentificacion();
		
		Usuario usuario2 = new Usuario(2,tipoIdentificacion2,"Tester2","Tester2");
		
		Cuenta cuentaReferencia = new Cuenta(2000,usuario2);
		
		Mockito.doReturn(cuentaReferencia).when(cuentaRepositoryMock).consultarCuentaReferencia(cobro.codigoDatafono());
		
		TipoTransaccion tipoTransaccion = new TipoTransaccion(TransaccionService.TRANSACCION_COMPRA, "COMPRA");
		
		Mockito.doReturn(tipoTransaccion).when(transaccionRepositoryMock).consultarTipoTransaccion(TransaccionService.TRANSACCION_COMPRA);
		
		TipoTransaccion tipoTransaccion2 = new TipoTransaccion(TransaccionService.TRANSACCION_VENTA, "VENTA");
		
		Mockito.doReturn(tipoTransaccion2).when(transaccionRepositoryMock).consultarTipoTransaccion(TransaccionService.TRANSACCION_VENTA);
		
		Mockito.doNothing().when(transaccionRepositoryMock).procesarPago(Mockito.eq(cuenta), Mockito.eq(cuentaReferencia), Mockito.any(Transaccion.class), Mockito.any(Transaccion.class), Mockito.eq(cobro));
		
		String mensajeEsperado= "No tiene saldo suficiente.";
		
		assertEquals(mensajeEsperado, transaccionService.procesarPago(codigoCobro, codigoCuenta));
			
	}

	
}
