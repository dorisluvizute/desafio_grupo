package com.qintess.desafio_grupo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dao implements DaoBase{

	public Connection getConnection() {
		
		Connection conn = null;		
		try {
			conn = DriverManager.getConnection(dvd_rentalAccess, user, password);			
		}
		catch(SQLException e){
			e.printStackTrace();
		}		
		return conn;
	}
	
	
}
