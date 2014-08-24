package com.freepay.dominio.excepciones;

public class ExcepcionNegocio extends Exception {
	public ExcepcionNegocio() {
	}
	
	public ExcepcionNegocio(String mensaje) {
		super(mensaje);
	}
	
	public ExcepcionNegocio(Throwable causa) {
		super(causa);
	}
	
	public ExcepcionNegocio(String mensaje, Throwable causa) {
		super(mensaje, causa);
	}
}
