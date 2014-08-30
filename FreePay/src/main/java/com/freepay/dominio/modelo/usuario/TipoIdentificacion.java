package com.freepay.dominio.modelo.usuario;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.hibernate.mapping.Value;

import com.freepay.dominio.modelo.datafono.Cobro;
import com.freepay.infraestructura.shared.ValueObject;

public class TipoIdentificacion implements ValueObject<TipoIdentificacion> {

	int codigo;
	String tipo;
	String nombre;
	
	public int codigo(){
		return codigo;
	}
	public String tipo(){
		return tipo;
	}
	public String nombre(){
		return nombre;
	}
	
	@Override
	public boolean sameValueAs(TipoIdentificacion other) {
		 return other != null && new EqualsBuilder().
			      append(this.codigo, other.codigo).
			      append(this.tipo, other.tipo).
			      append(this.nombre, other.nombre).
			      isEquals();		
	}
	
}
