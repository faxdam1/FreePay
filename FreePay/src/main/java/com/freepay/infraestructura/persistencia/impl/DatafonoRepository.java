package com.freepay.infraestructura.persistencia.impl;

import java.util.List;

import com.freepay.dominio.modelo.datafono.*;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class DatafonoRepository implements IDatafonoRepository{
	
	HibernateTemplate hibernateTemplate;
	
	public DatafonoRepository(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	public void guardarCobro(Cobro cobro){
		try{
			hibernateTemplate.save(cobro);
		}catch(DataAccessException ex){throw ex;}
     }
	
	
	public Cobro consultarCobro(int codigoCobro){
		try{
			List lisCobro=hibernateTemplate.find("from Cobro where codigo=?",codigoCobro);		
			if(lisCobro.isEmpty()) return null;
			return ((List<Cobro>)lisCobro).get(0);	
		}catch(DataAccessException ex){throw ex;}
		
	}

}
