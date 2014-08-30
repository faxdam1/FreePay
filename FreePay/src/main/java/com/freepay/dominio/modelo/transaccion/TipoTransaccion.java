package com.freepay.dominio.modelo.transaccion;


import org.apache.commons.lang3.builder.EqualsBuilder;
import com.freepay.infraestructura.shared.ValueObject;

public class TipoTransaccion implements ValueObject<TipoTransaccion>  {
	
	int codigo;
	String tipo;
	
	public int codigo(){
		return codigo;
	}
	public String tipo(){
		return tipo;
	}
	
	@Override
	public boolean sameValueAs(TipoTransaccion other) {
		 return other != null && new EqualsBuilder().
			      append(this.codigo, other.codigo).
			      append(this.tipo, other.tipo).			 
			      isEquals();		
	}
	

}
