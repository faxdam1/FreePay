package com.freepay.dominio.servicio;

import com.freepay.dominio.excepciones.ExcepcionNegocio;
import com.freepay.dominio.modelo.datafono.*;

public class DatafonoService {
	
	private IDatafonoRepository datafonoRepository; 
	
	public Cobro generarCobro(final int codigoDatafono, final String referencia, final int valorPagar) throws ExcepcionNegocio, Exception {
		String mensaje = null;
		
		mensaje = Cobro.validarValorPagar(valorPagar);
		if(mensaje != null) {
			throw new ExcepcionNegocio("Error al generar el cobro: " + mensaje);
		}
		
		try {
	    	Cobro cobro = new Cobro(codigoDatafono, referencia, valorPagar);
	    	datafonoRepository.guardarCobro(cobro);
	    	return cobro;
		} catch(Exception ex) {
			throw ex;
		}
    }
	
	public void setDatafonoRepository(IDatafonoRepository datafonoRepository) {
		this.datafonoRepository = datafonoRepository;
	}
	
}
