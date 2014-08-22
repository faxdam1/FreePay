package com.freepay.dominio.modelo.datafono;

import com.freepay.infraestructura.shared.Entity;

public class Cobro implements Entity<Cobro> {

    private int codigo;
    private int codigoDatafono;
    private String referencia;
    private int valorPagar;

    public Cobro(final int codigoDatafono, final String referencia,final int valorPagar) {
        this.codigo = generarCodigo();
        this.codigoDatafono=codigoDatafono;
        this.referencia=referencia;
        this.valorPagar=valorPagar;
    }
   
    private int generarCodigo(){
         return (int)Math.random();
    }
    
    public int getCodigo(){
    	return this.codigo;
    }
    
    @Override
    public boolean sameIdentityAs(final Cobro other) {
        return other!=null&&other.codigo == this.codigo;
    }
    
 }
