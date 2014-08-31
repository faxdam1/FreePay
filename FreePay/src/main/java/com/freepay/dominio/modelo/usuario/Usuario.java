package com.freepay.dominio.modelo.usuario;

import java.util.Collections;
import java.util.List;

import com.freepay.dominio.modelo.cuenta.Cuenta;
import com.freepay.infraestructura.shared.Entity;

public class Usuario implements Entity<Usuario>  {

	long identificacion;
	String usuario;
	String clave;
	int codigo;
	TipoIdentificacion tipoIdentificacion;
	List<Cuenta> cuentas=Collections.emptyList();
	
	public Usuario(){}
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
	public List<Cuenta> cuentas(){
		return cuentas;
	}

	
	@Override
	public boolean sameIdentityAs(final Usuario other) {
	        return other!=null&&other.usuario == this.usuario;
	}
	
}
