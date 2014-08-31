package com.freepay.dominio.modelo.empresa;

import java.util.List;

import com.freepay.dominio.modelo.datafono.Datafono;
import com.freepay.dominio.modelo.usuario.Usuario;
import com.freepay.infraestructura.shared.Entity;

public class Empresa  implements Entity<Empresa>  {
	  
	int codigo;
	String nombre;
	String nit;
	Usuario usuario;
	
	public Empresa(){}
	public Empresa(final String nombre, final String nit, final Usuario usuario){
		this.nombre=nombre;
		this.nit=nit;
		this.usuario=usuario;
	}
	
	public int codigo() {
		return codigo;
	}	
	public String nombre() {
		return nombre;
	}
	public String nit() {
		return nit;
	}
	public Usuario usuario() {
		return usuario;
	}
	
	@Override
	public boolean sameIdentityAs(final Empresa other) {
	        return other!=null&&other.codigo == this.codigo;
	}
}
