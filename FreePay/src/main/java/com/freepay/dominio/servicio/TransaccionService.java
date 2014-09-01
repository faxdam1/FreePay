package com.freepay.dominio.servicio;

import com.freepay.dominio.modelo.cuenta.Cuenta;
import com.freepay.dominio.modelo.cuenta.ICuentaRepository;
import com.freepay.dominio.modelo.datafono.Cobro;
import com.freepay.dominio.modelo.datafono.IDatafonoRepository;
import com.freepay.dominio.modelo.transaccion.ITransaccionRepository;
import com.freepay.dominio.modelo.transaccion.TipoTransaccion;
import com.freepay.dominio.modelo.transaccion.Transaccion;

public class TransaccionService {

		private IDatafonoRepository datafonoRepository;
		private ICuentaRepository cuentaRepository;
		private ITransaccionRepository transaccionRepository;
		public static final int TRANSACCION_COMPRA=3;
		public static final int TRANSACCION_VENTA=4;
		
	    public String procesarPago(int codigoCobro,int codigoCuenta){
	    	try{
		    
	    		String mensaje;
	    		Cobro cobro=datafonoRepository.consultarCobro(codigoCobro);
		    	Cuenta cuenta=cuentaRepository.consultarCuenta(codigoCuenta);
		    	Cuenta cuentaReferencia=cuentaRepository.consultarCuentaReferencia(cobro.codigoDatafono());
		    	mensaje= cuenta.retirarSaldo(cobro.valorPagar());
		    	if(mensaje!=null){return mensaje;}
		    	mensaje= cuentaReferencia.consignarSaldo(cobro.valorPagar());
		    	if(mensaje!=null){return mensaje;}
		    	mensaje=  cobro.pagar();
		    	if(mensaje!=null){return mensaje;}
		        Transaccion transaccionCompra=  new Transaccion(cuenta,cuentaReferencia,0,cobro.valorPagar()*-1,transaccionRepository.consultarTipoTransaccion(TRANSACCION_COMPRA));
		        Transaccion transaccionVenta= new Transaccion(cuentaReferencia,cuenta,0,cobro.valorPagar(),transaccionRepository.consultarTipoTransaccion(TRANSACCION_VENTA));
		        transaccionRepository.procesarPago(cuenta, cuentaReferencia,transaccionCompra,transaccionVenta,cobro);
		    	return "Saldo actual: "+cuenta.saldo();
		    	
	    	}catch(Exception ex){
	    		ex.printStackTrace();
	    		throw ex;}
	    }
	    
	    
	    
	    
	    
	    public void setDatafonoRepository(IDatafonoRepository datafonoRepository) {
			this.datafonoRepository = datafonoRepository;
		}
		
		public void setCuentaRepository(ICuentaRepository cuentaRepository) {
			this.cuentaRepository = cuentaRepository;
		}

		public void setTransaccionRepository(
				ITransaccionRepository transaccionRepository) {
			this.transaccionRepository = transaccionRepository;
		}
	 
}
