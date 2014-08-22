package com.freepay.dominio.servicio;

import com.freepay.dominio.modelo.datafono.*;

public class DatafonoService {
	
	private IDatafonoRepository datafonoRepository; 
	
	public int generarCobro(final int codigoDatafono,final String referencia,final int valorPagar){
    	Cobro cobro=new  Cobro(codigoDatafono,referencia,valorPagar);
    	if(datafonoRepository.guardarCobro(cobro)){
    		return cobro.getCodigo();
    	}else{
    		return 0;
    	}
    }
	
	public void setDatafonoRepository(IDatafonoRepository datafonoRepository) {
		this.datafonoRepository = datafonoRepository;
	}
	
}
