package com.qintess.desafio_grupo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.qintess.desafio_grupo.entities.Customer;

public class CustomerDao{

	Scanner sc = new Scanner(System.in);
	Dao connection = new Dao();	
	Connection connect = connection.getConnection();

	public void insert(Integer address_id) {

		String sql = "insert into customer (first_name, last_name, email, "
				+ "activebool, store_id, active, address_id) VALUES (?, ?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement ps = connect.prepareStatement(sql);

			System.out.print("Informe o primeiro nome: ");
			String first_name = sc.next();
			ps.setString(1, first_name);

			System.out.print("Infome o último nome: ");
			String last_name = sc.next();
			ps.setString(2, last_name);

			System.out.print("Informe o email: ");
			String email = sc.next();
			ps.setString(3, email);

			System.out.print("O usuário está ativo?  S / N: ");
			String ativo = sc.next().toUpperCase();
			if(ativo.equals("S")) {
				ps.setBoolean(4, true);
				ps.setInt(6, 1);
			}
			else {
				ps.setBoolean(4, false);
				ps.setInt(6, 0);
			}

			System.out.print("Informe o ID da loja: ");
			Integer store_id = sc.nextInt();
			ps.setInt(5, store_id);

			ps.setInt(7, address_id);

			int affectedRows = ps.executeUpdate();

			if(affectedRows == 0) {
				throw new SQLException("Creating user failed, no rows affected.");
			}
			else {
				System.out.println("Usuário Inserido!");
			}

		}
		catch(SQLException e) {
			e.printStackTrace();
		}


	}

	public void delete() {

		String sql = "DELETE FROM CUSTOMER WHERE CUSTOMER.CUSTOMER_ID = ?";

		try {
			PreparedStatement ps = connect.prepareStatement(sql);

			System.out.print("Informe o ID do cliente a ser deletado: ");
			Integer customer_id = sc.nextInt();
			ps.setInt(1, customer_id);

			int affectedRows = ps.executeUpdate();

			if(affectedRows == 0) {
				throw new SQLException("Delete user failed, no rows affected.");
			}			
			else {
				System.out.println("Usuário Deletado!");
			}
			
		}

		catch(SQLException e) {
			e.printStackTrace();
		}

	}

	public void update() {

		String sql = "UPDATE CUSTOMER SET LAST_NAME = ?, EMAIL = ?, ACTIVE = ? WHERE CUSTOMER_ID = ?";

		try {
			PreparedStatement ps = connect.prepareStatement(sql);

			System.out.print("Informe o ID do cliente a ser alterado: ");
			Integer customer_id = sc.nextInt();
			ps.setInt(4, customer_id);

			System.out.print("Informe o sobrenome a ser modificado: ");
			String last_name = sc.next();
			ps.setString(1, last_name);

			System.out.print("Informe o email a ser modificado: ");
			String email = sc.next();
			ps.setString(2, email);

			System.out.print("O usuário está ativo? S / N: ");
			String active = sc.next().toUpperCase();
			if(active.equals("S")){
				ps.setInt(3, 1);
			}
			else {
				ps.setInt(3, 0);
			}

			int affectedRows = ps.executeUpdate();

			if(affectedRows == 0) {
				throw new SQLException("Update user failed, no rows affected.");
			}			
			else {
				System.out.println("Usuário Atualizado!");
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}

	}

	public void inicial() {
		AddressDao ad = new AddressDao();
		System.out.print("Deseja fazer qual operação: Inserir, deletar, atualizar ou buscar? I / D / A / B: ");
		String operacao = sc.next().toUpperCase();

		switch(operacao) {
		case "I": 
			Integer address_id = ad.insert();
			this.insert(address_id);
			break;
		case "D":
			this.delete();
			break;
		case "A":
			this.update();
			break;		
		case "B":
			System.out.println(this.retrieve());
			break;
		}
	}
	
	public String retrieve() {
		
		String sql = "SELECT * FROM CUSTOMER WHERE CUSTOMER.CUSTOMER_ID = ?";
		
		Customer cus = new Customer();
		
		try {
			PreparedStatement ps = connect.prepareStatement(sql);
			
			System.out.println("Informe o ID do cliente que quer vizualizar: ");
			int customer_id = sc.nextInt();
			ps.setInt(1, customer_id);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				cus.setCustomer_id(rs.getInt("customer_id"));
				cus.setStore_id(rs.getInt("store_id"));
				cus.setFirst_name(rs.getString("first_name"));
				cus.setLast_name(rs.getString("last_name"));
				cus.setEmail(rs.getString("email"));
				cus.setAddress_id(rs.getInt("address_id"));
				cus.setActivebool(rs.getBoolean("activebool"));
				cus.setCreate_date(rs.getString("create_date"));
				cus.setLast_update(rs.getString("last_update"));
				cus.setActive(rs.getInt("active"));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cus.toString();
	}
}
