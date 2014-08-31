package com.freepay.dominio.modelo.transaccion;

import com.freepay.dominio.modelo.cuenta.Cuenta;
import com.freepay.dominio.modelo.datafono.Cobro;

public interface ITransaccionRepository {

	
	public TipoTransaccion consultarTipoTransaccion(int codigo);
	public void procesarPago(Transaccion compra,Transaccion venta, Cobro cobro);
	
}
