package com.freepay.dominio.modelo.usuario;

import com.freepay.infraestructura.shared.Entity;

public class Usuario implements Entity<Usuario>  {

	long identificacion;
	String usuario;
	String clave;
	int codigo;
	TipoIdentificacion tipoIdentificacion;
	
	public Usuario(final long identificacion,final TipoIdentificacion tipoIdentificacion,final String usuario, final String clave){
		this.identificacion=identificacion;
		this.tipoIdentificacion=tipoIdentificacion;
		this.usuario=usuario;
		this.clave=clave;
	}
	
	public long indentificacion(){
		return identificacion;
	}
	public String usuario(){
		return usuario;
	}
	public String clave(){
		return clave();
	}
	public int codigo(){
		return codigo;
	}
	public TipoIdentificacion tipoIdentificacion(){
		return tipoIdentificacion;
	}	
	
	@Override
	public boolean sameIdentityAs(final Usuario other) {
	        return other!=null&&other.usuario == this.usuario;
	}
	
}
