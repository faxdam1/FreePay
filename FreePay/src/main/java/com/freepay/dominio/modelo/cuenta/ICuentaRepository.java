package com.freepay.dominio.modelo.cuenta;

public interface ICuentaRepository {
	
	public Cuenta consultarCuentaReferencia(int codigoDatafono);
	public Cuenta consultarCuenta(int codigoCuenta);
	public void guardarCuenta(Cuenta cuenta);

}
