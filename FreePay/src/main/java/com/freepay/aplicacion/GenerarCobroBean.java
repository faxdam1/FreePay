package com.freepay.aplicacion;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.springframework.stereotype.Controller;

import com.freepay.dominio.servicio.DatafonoService;
import com.freepay.dominio.modelo.datafono.Cobro;


@Controller("generarCobroBean") 
@ManagedBean(name = "generarCobroBean")
@SessionScoped
public class GenerarCobroBean  implements Serializable  {

	private DatafonoService datafonoService;
	private Cobro cobro=new Cobro();
	private boolean mostrarMensaje=true;
	
	
	public void generarCobro(ActionEvent actionEvent){
		try{
			cobro=datafonoService.generarCobro(1,cobro.referencia(),cobro.valorPagar());
			ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
			ec.redirect(ec.getRequestContextPath() + "/View/GenerarCobro/ConsultarCobroView.xhtml");
			mostrarMensaje=true;
		}catch (Exception ex) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Error en la creacion del cobro."));
		}
	}
	
	public void confirmarPago(){
		try{
			if(mostrarMensaje){
				if(datafonoService.confirmarPago(cobro)){
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Confirmacion de pago: ", "Pago realizado exitosamente."));
					mostrarMensaje=false;
				}
			}
		}catch (Exception ex) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Error en la creacion del cobro."));
		}
	}
	
	public int getCodigoCobro() {
		return cobro.codigo();
	}

	public String getReferencia() {
		return cobro.referencia();
	}
	
	public int getValorPagar() {
		return cobro.valorPagar();
	}

	public void setReferencia(String referencia) {
		cobro.cambiarReferencia(referencia);
	}	

	public void setValorPagar(int valorPagar) {
		cobro.cambiarValorPagar(valorPagar);
	}
	
	public boolean isMostrarMensaje() {
		return mostrarMensaje;
	}

	public void setMostrarMensaje(boolean mostrarMensaje) {
		this.mostrarMensaje = mostrarMensaje;
	}
	
	public void setDatafonoService(DatafonoService datafonoService) {
		this.datafonoService = datafonoService;
	}

}
