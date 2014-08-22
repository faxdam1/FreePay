package com.freepay.dominio.servicio;

import com.freepay.dominio.modelo.datafono.IDatafonoRepository;
import com.freepay.dominio.modelo.datafono.Datafono;
import com.freepay.dominio.modelo.datafono.Cobro;


public class DatafonoService {
	
    private IDatafonoRepository iDatafonoRepository;
    
	public Cobro generarCobro(Datafono datafono){
		
		datafono.buscarCobro();
		
		//Crear en BD
		//Consultar
		
		return null;
	}
	

}
