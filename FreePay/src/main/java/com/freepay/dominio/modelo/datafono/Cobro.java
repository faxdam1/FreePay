package com.freepay.dominio.modelo.datafono;

import java.io.Serializable;

import com.freepay.infraestructura.shared.Entity;

public class Cobro implements Entity<Cobro>  {

    private int codigo;
	private int codigoDatafono;
    private String referencia;
    private int valorPagar;
    private int estado;
	
	public Cobro(){}
    public Cobro(final int codigoDatafono, final String referencia,final int valorPagar) {
        this.codigo = generarCodigo();
        this.codigoDatafono=codigoDatafono;
        this.referencia=referencia;
        this.valorPagar=valorPagar;
    }
   
    private int generarCodigo(){
         return (int) Math.floor(Math.random()*(100000000-1000000+1)+1000000);
    }
   
    public void cambiarReferencia(String referencia){
    	this.referencia=referencia;
    }
    
    public void cambiarValorPagar(int valorPagar){
    	this.valorPagar=valorPagar;
    }
    
    public int codigo() {
		return this.codigo;
	}
    
    public int codigoDatafono(){
		return this.codigoDatafono;
	}
	
	public String referencia(){
		return this.referencia;
	}
	
	public int valorPagar(){
		return this.valorPagar;
	}
	
	public int estado(){
		return this.estado;
	}
	    
    @Override
    public boolean sameIdentityAs(final Cobro other) {
        return other!=null&&other.codigo == this.codigo;
    }
    
    public String pagar(){
    	if(this.estado==1){
    		return "Est� intentando pagar una cuenta de cobro y� paga.";
    	}
    	this.estado=1;
    	return null;
    }
    
    public static String validarValorPagar(int valorPagar) {
    	String mensaje = null;
    	if(valorPagar <= 0) {
    		mensaje = "El valor a pagar no puede ser menor o igual a cero.";
    	}
    	return mensaje;
    }
}
