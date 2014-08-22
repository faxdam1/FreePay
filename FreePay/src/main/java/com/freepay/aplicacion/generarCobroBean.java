package com.freepay.aplicacion;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.freepay.dominio.servicio.DatafonoService;
import com.freepay.dominio.modelo.datafono.Cobro;


@Controller("generarCobroBean") 
@ManagedBean(name = "generarCobroBean")
@ViewScoped
public class generarCobroBean  implements Serializable  {

	private DatafonoService datafonoService;
	
	private int codigoCobro; 
	private String referencia;
	private int valorPagar;
	 
	public void generarCobro(ActionEvent actionEvent){
		codigoCobro=datafonoService.generarCobro(1,referencia,valorPagar);
		if(codigoCobro!=0){
			
		}else{
			
		}
	}
	
	public int getCodigoCobro() {
		return codigoCobro;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public int getValorPagar() {
		return valorPagar;
	}

	public void setValorPagar(int valorPagar) {
		this.valorPagar = valorPagar;
	}

	
	public void setDatafonoService(DatafonoService datafonoService) {
		this.datafonoService = datafonoService;
	}

}
