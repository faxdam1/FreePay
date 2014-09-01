package com.freepay.infraestructura.persistencia.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.freepay.dominio.modelo.cuenta.Cuenta;
import com.freepay.dominio.modelo.datafono.Cobro;
import com.freepay.dominio.modelo.transaccion.ITransaccionRepository;
import com.freepay.dominio.modelo.transaccion.TipoTransaccion;
import com.freepay.dominio.modelo.transaccion.Transaccion;

@Repository
public class TransaccionRepository implements ITransaccionRepository {
	
	HibernateTemplate hibernateTemplate;
	public TransaccionRepository(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}
	
	public void procesarPago(Cuenta cuenta,Cuenta cuentaReferencia,Transaccion transaccionCompra,Transaccion transaccionVenta, Cobro cobro){
		try{

			hibernateTemplate.update(cuenta);
			hibernateTemplate.update(cuentaReferencia);
			hibernateTemplate.save(transaccionCompra);
			hibernateTemplate.save(transaccionVenta);
			hibernateTemplate.update(cobro);
		}
		catch(DataAccessException ex){
			throw ex;
		}
     }	
	
	public TipoTransaccion consultarTipoTransaccion(int codigo){
		try{
			List lisTipoTransaccion=hibernateTemplate.find("FROM TipoTransaccion WHERE codigo=?",codigo);		
			if(lisTipoTransaccion.isEmpty()) return null;
			return ((List<TipoTransaccion>)lisTipoTransaccion).get(0);	
		}catch(DataAccessException ex){throw ex;}		
	}
	
}
