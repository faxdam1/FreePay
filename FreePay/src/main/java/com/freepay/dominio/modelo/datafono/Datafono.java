package com.freepay.dominio.modelo.datafono;

public class Datafono {
	
	private int codigo;
	private String nombre;
	private Cobro cobro=new Cobro();
	
	public Cobro buscarCobro(){
		return 	cobro;
	}
	
}
