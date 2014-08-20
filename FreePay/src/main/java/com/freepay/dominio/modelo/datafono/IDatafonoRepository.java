package com.freepay.dominio.modelo.datafono;

public interface IDatafonoRepository {

	boolean guardarCobro(Cobro cuentaCobro);
	
	Cobro consultarCobro(int codigoCobro);
	
}
