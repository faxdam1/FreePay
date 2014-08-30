package com.freepay.aplicacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.freepay.dominio.servicio.TransaccionService;

@RestController
@Controller("pago") 
@RequestMapping("/Pago")
public class PagoRest {
		
	private TransaccionService transaccionService;
	
	public void setTransaccionService(TransaccionService transaccionService){
		this.transaccionService=transaccionService;
	}
	
	@RequestMapping(value = "/{codigoCobro}/{codigoCuenta}",  method = RequestMethod.GET)
	public String procesarPago(@PathVariable int codigoCobro,@PathVariable int codigoCuenta){
		try{	
			return transaccionService.procesarPago(codigoCobro,codigoCuenta);
		}catch(Exception ex){
			return "Error";
		}
	}

}
