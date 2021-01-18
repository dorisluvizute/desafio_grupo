package com.qintess.desafio_grupo.dao;

import java.sql.Connection;

public interface DaoBase {

	final String dvd_rentalAccess = "jdbc:postgresql://localhost:5432/dvdrental";
	final String user = "postgres";
	final String password = "qintess@123";
	
	public Connection getConnection();
}
