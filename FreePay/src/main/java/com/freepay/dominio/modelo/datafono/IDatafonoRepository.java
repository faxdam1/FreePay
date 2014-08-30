package com.freepay.dominio.modelo.datafono;

public interface IDatafonoRepository {
	
	public void guardarCobro(Cobro cobro);
	public Cobro consultarCobro(int codigoCobro);

}
