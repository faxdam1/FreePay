package com.freepay.dominio.modelo.cuenta;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.freepay.dominio.modelo.transaccion.TipoTransaccion;
import com.freepay.dominio.modelo.transaccion.Transaccion;
import com.freepay.dominio.modelo.usuario.Usuario;
import com.freepay.infraestructura.shared.Entity;

public class Cuenta  implements Entity<Cuenta> {

	int codigo;
	long saldo;
	Usuario usuario;
	List<Transaccion> transacciones=Collections.emptyList();
	
	public Cuenta(){}
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
	public List<Transaccion> transacciones(){
		return transacciones;
	}
	
	@Override
	public boolean sameIdentityAs(final Cuenta other) {
	        return other!=null&&other.codigo == this.codigo;
	}
	
	public String consignarSaldo(long valorConsignacion){
		if(valorConsignacion>0){
		  this.saldo=this.saldo+valorConsignacion;
		  return null;
		}
		return "El valor a consignar debe ser mayor a 0.";		
	}
	
	public String retirarSaldo(long valorRetiro){
		if(valorRetiro>this.saldo){
			return "No tiene saldo suficiente.";
		}
		if(valorRetiro<=0){
			return "El valor a retirar debe ser mayor a 0.";
		}
		this.saldo=this.saldo-valorRetiro;	
		return null;
	}		

	
}
