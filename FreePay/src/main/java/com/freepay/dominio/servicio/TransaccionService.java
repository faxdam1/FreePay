package com.freepay.dominio.servicio;

import com.freepay.dominio.modelo.datafono.IDatafonoRepository;

public class TransaccionService {

		private IDatafonoRepository datafonoRepository;
		
		public void setDatafonoRepository(IDatafonoRepository datafonoRepository) {
			this.datafonoRepository = datafonoRepository;
		}
		
	    public String procesarPago(int codigoCobro,int codigoCuenta){
	    		
	    	
	    	
	    	
	    	
	    	
	    	return "Hola Mundo"+codigoCobro+codigoCuenta;
	    }
	    
	    //Crear la transaccion de compra
		//Crear la transaccion de venta
		// Actualizar cuenta comprador -Consultar cuenta con CuentaService
		// Actualizar cuenta vendedor
	    //Notificar Saldo Cuenta origen 
	    //Si no se puede hacer notificar no tiene saldo
}
