package com.freepay.dominio.modelo.datafono;

import com.freepay.dominio.modelo.empresa.Empresa;
import com.freepay.infraestructura.shared.Entity;

public class Datafono implements Entity<Datafono>{

    private int codigo;
    private String nombre;
    private Empresa empresa;

    public Datafono(){}
    public Datafono(final int codigo, final String nombre, final Empresa empresa) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.empresa=empresa;
    }
    
    public int codigo(){
    	return this.codigo;
    }
    
    @Override
    public boolean sameIdentityAs(final Datafono other) {
        return other!=null&&other.codigo == this.codigo;
    }
    
 }
