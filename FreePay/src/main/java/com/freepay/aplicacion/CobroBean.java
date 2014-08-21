package com.freepay.aplicacion;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.springframework.stereotype.Controller;


@Controller("CobroBean") 
@ManagedBean(name = "CobroBean")
@ViewScoped
public class CobroBean  implements Serializable  {
	
	
	 public void agregarCliente(ActionEvent actionEvent) {

		 
	 }
	
	 
	 private String texto="Hola Mundo";


	public String getTexto() {
		return texto;
	}


	public void setTexto(String texto) {
		this.texto = texto;
	}
	 
	 
	 
}
