package com.freepay.dominio.modelo.transaccion;

import java.util.Date;

import com.freepay.dominio.modelo.cuenta.Cuenta;
import com.freepay.dominio.modelo.datafono.Cobro;
import com.freepay.infraestructura.shared.Entity;

public class Transaccion  implements Entity<Transaccion>{

	int codigo;
	Cuenta cuenta;
	int  cuentaRef;
	Date fechaHora;
	int codigoComision;
	long valor;
	TipoTransaccion tipoTransaccion;
	
	public Transaccion(){}
	public Transaccion(final Cuenta cuenta,final  int cuentaRef, final int codigoComision, final long valor,final TipoTransaccion tipoTransaccion){
			this.cuenta=cuenta;
			this.cuentaRef=cuentaRef;
			this.codigoComision=codigoComision;
			this.valor=valor;
			this.tipoTransaccion=tipoTransaccion;
			this.fechaHora=new Date();
	}
	
	public int codigo() {
		return codigo;
	}
	public Cuenta cuenta() {
		return cuenta;
	}
	public Cuenta cuentaRef() {
		return cuentaRef;
	}
	public Date fechaHora() {
		return fechaHora;
	}
	public int codigoComision() {
		return codigoComision;
	}
	public long valor() {
		return valor;
	}
	public TipoTransaccion tipoTransaccion() {
		return tipoTransaccion;
	}
	
    @Override
    public boolean sameIdentityAs(final Transaccion other) {
        return other!=null&&other.codigo == this.codigo;
    }
}
