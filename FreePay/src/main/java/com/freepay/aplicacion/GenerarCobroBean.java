package com.freepay.aplicacion;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.springframework.stereotype.Controller;
import com.freepay.dominio.modelo.datafono.*;
import com.freepay.dominio.servicio.DatafonoService;


@Controller("generarCobroBean") 
@ManagedBean(name = "generarCobroBean")
@ViewScoped
public class GenerarCobroBean  implements Serializable  {
	
	private Datafono datafono;	
	private DatafonoService datafonoService;
	
	//Metodos
	public void generarCobro(ActionEvent actionEvent){
		
		
	}	
	 
}
