package com.freepay.dominio.modelo.cuenta;

import com.freepay.dominio.modelo.usuario.Usuario;
import com.freepay.infraestructura.shared.Entity;

public class Cuenta  implements Entity<Cuenta> {

	int codigo;
	long saldo;
	Usuario usuario;
	
	public Cuenta(final long saldo,final Usuario usuario){
		this.saldo=saldo;
		this.usuario=usuario;
	}
	
	public int codigo(){
		return codigo;
	}
	public long saldo(){
		return saldo;
	}
	public Usuario usuario(){
		return usuario;
	}	
	
	@Override
	public boolean sameIdentityAs(final Cuenta other) {
	        return other!=null&&other.codigo == this.codigo;
	}
}
