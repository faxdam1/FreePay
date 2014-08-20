package com.freepay.infraestructura.persistencia.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.freepay.dominio.modelo.datafono.Cobro;
import com.freepay.dominio.modelo.datafono.IDatafonoRepository;

public class DatafonoRepository implements IDatafonoRepository{
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public boolean guardarCobro(Cobro cobro){

		return this.jdbcTemplate.update("insert into cobro (codigo,referencia,valorPagar) values (?,?,?)",cobro.getCodigo(), cobro.getReferencia(),cobro.getValorPagar())>0?true:false;
	
	}
	
	public Cobro consultarCobro(int codigoCobro){
		
		Cobro cobro = this.jdbcTemplate.
				queryForObject("select codigo,referencia,valorPagar from cobro where codigo=?",
				 new Object[]{codigoCobro}, 
				 		new RowMapper<Cobro>() {
	                    public Cobro mapRow(ResultSet rs, int rowNum)throws SQLException {
	                    	return new Cobro(rs.getInt("codigo"),rs.getString("referencia"),rs.getDouble("valorPagar"));
	                    }
	             });
		
		return cobro;
	}

}
