package com.freepay.dominio.modelo.datafono;

public class Cobro {

	private int codigo;
	private String referencia;
	private double valorPagar; 
	
	
	public Cobro(int codigo,String referencia, double valorPagar){
	    this.codigo=codigo;
		this.referencia=referencia;
		this.valorPagar=valorPagar;
	}


	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getReferencia() {
		return referencia;
	}	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public double getValorPagar() {
		return valorPagar;
	}
	public void setValorPagar(double valorPagar) {
		this.valorPagar = valorPagar;
	}
	
}
