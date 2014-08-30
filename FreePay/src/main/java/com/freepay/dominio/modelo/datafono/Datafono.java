package com.freepay.dominio.modelo.datafono;

import com.freepay.infraestructura.shared.Entity;

public class Datafono implements Entity<Datafono>{

    private int codigo;
    private String nombre;
    private int codigoEmpresa;

    public Datafono(final int codigo, final String nombre, final int codigoEmpresa) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.codigoEmpresa=codigoEmpresa;
    }
    
    public int getCodigo(){
    	return this.codigo;
    }
    
    @Override
    public boolean sameIdentityAs(final Datafono other) {
        return other!=null&&other.codigo == this.codigo;
    }
    
 }
