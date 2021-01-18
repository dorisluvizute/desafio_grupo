package com.qintess.desafio_grupo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.qintess.desafio_grupo.entities.Address;

public class AddressDao {

	Scanner sc = new Scanner(System.in);
	Dao connection = new Dao();	
	Connection connect = connection.getConnection();

	public Integer insert() {
		
		Address add = new Address();
		
		try {
						
			PreparedStatement ps = connect.prepareStatement("INSERT INTO ADDRESS(ADDRESS, DISTRICT, CITY_ID, "
					+ "POSTAL_CODE, PHONE, LAST_UPDATE) VALUES (?, ?, 10, ?, ?, NOW())",
					Statement.RETURN_GENERATED_KEYS);
			
			System.out.print("Informe o endereço: ");
			String address = sc.nextLine();
			ps.setString(1, address);
			
			System.out.print("Informe o distrito: ");
			String district = sc.next();
			ps.setString(2, district);
			
			System.out.print("Informe o código postal: ");
			Integer postal_code = sc.nextInt();
			ps.setInt(3, postal_code);
			
			System.out.print("Informe o telefone: ");
			Long phone = sc.nextLong();
			ps.setLong(4, (long) phone);	
			
			int affectedRows = ps.executeUpdate();
			
			if (affectedRows == 0) {
				throw new SQLException("Creating address failed, no rows affected.");
			}
			else {
				try (ResultSet rs = ps.getGeneratedKeys()) {
					if (rs.next()) {
						add.setAddress_id(rs.getInt("address_id"));
					} else {
						throw new SQLException("Creating address failed, no ID obtained.");
					}
				}
				System.out.println("Endereço Inserido!");
			}
			
			
		}
		
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return add.getAddress_id();
	}

	public void delete() {
		
		String sql = "DELETE FROM ADDRESS WHERE ADDRESS.ADDRESS_ID = ?";
		
		try {
			
			PreparedStatement ps = connect.prepareStatement(sql);	
			
			System.out.print("Insira o ID do endereço a ser deletado: ");
			Integer address_id = sc.nextInt();
			ps.setInt(1, address_id);
			
			int affectedRows = ps.executeUpdate();

			if (affectedRows == 0) {
				throw new SQLException("Delete address failed, no rows affected.");
			}	
			else {
				System.out.println("Endereço Deletado!");
			}
			

		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		

	}

	public void update() {
		
		String sql = "UPDATE ADDRESS SET ADDRESS = ?, POSTAL_CODE = ?, PHONE = ? WHERE ADDRESS_ID = ?";
		
		try {
			PreparedStatement ps = connect.prepareStatement(sql);

			System.out.print("Insira o ID do endereço a ser alterado: ");
			Integer address_id = sc.nextInt();
			ps.setInt(4, address_id);
			
			System.out.print("Insira o novo endereço: ");
			String address = sc.next();
			ps.setString(1, address);
			
			System.out.print("Insira o novo código postal: ");
			Integer postal_code = sc.nextInt();
			ps.setInt(2, postal_code);
			
			System.out.print("Insira o novo telefone: ");
			String phone = sc.next();
			ps.setLong(3, Long.parseLong(phone));
			
			int affectedRows = ps.executeUpdate();

			if (affectedRows == 0) {
				throw new SQLException("Update address failed, no rows affected.");
			}	
			else {
				System.out.println("Endereço Atualizado!");
			}
			
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
}
