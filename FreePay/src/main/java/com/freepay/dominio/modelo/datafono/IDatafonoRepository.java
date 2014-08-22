package com.freepay.dominio.modelo.datafono;

public interface IDatafonoRepository {

	int guardarCobro(Cobro cuentaCobro);
	
	Cobro consultarCobro(int codigoCobro);
	
}
