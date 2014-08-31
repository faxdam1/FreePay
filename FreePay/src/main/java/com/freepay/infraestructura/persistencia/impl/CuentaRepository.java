package com.freepay.infraestructura.persistencia.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import com.freepay.dominio.modelo.cuenta.Cuenta;
import com.freepay.dominio.modelo.cuenta.ICuentaRepository;



@Repository
public class CuentaRepository implements ICuentaRepository  {

	HibernateTemplate hibernateTemplate;
	public CuentaRepository(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}
	
	public Cuenta consultarCuentaReferencia(int codigoDatafono){
		try{
			List lisCuenta=hibernateTemplate.find(
					"SELECT usuario.cuentas FROM Datafono datafono "
					+"LEFT JOIN datafono.empresa empresa "
					+"LEFT JOIN empresa.usuario usuario	"
					+"WHERE datafono.codigo=?",codigoDatafono);		
			if(lisCuenta.isEmpty()) return null;
			return ((List<Cuenta>)lisCuenta).get(0);	
		}catch(DataAccessException ex){throw ex;}
	}
	
	public Cuenta consultarCuenta(int codigoCuenta){
		try{
			List lisCuenta=hibernateTemplate.find(
					"FROM Cuenta cuenta WHERE cuenta.codigo=?",codigoCuenta);		
			if(lisCuenta.isEmpty()) return null;
			return ((List<Cuenta>)lisCuenta).get(0);	
		}catch(DataAccessException ex){throw ex;}
	}	
	
	public void guardarCuenta(Cuenta cuenta){
		try{
			hibernateTemplate.saveOrUpdate(cuenta);
		}catch(DataAccessException ex){throw ex;}
     }	
}
