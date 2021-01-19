package com.qintess.desafio_grupo.dao;

import java.nio.charset.IllegalCharsetNameException;
import java.sql.*;
import java.util.Scanner;
import com.qintess.desafio_grupo.entities.Film;

public class FilmDao{

	Scanner sc = new Scanner(System.in);
	Dao connection = new Dao();	
	Connection connect = connection.getConnection();
	Film film = new Film();

	public Integer insert(String title, String description, Integer release_year, Integer language_id,
						  Integer rental_duration, Double rental_rate, Integer length, Double replacement_cost) {

		try {
			String sql = "INSERT INTO FILM(TITLE, DESCRIPTION, RELEASE_YEAR, LANGUAGE_ID, RENTAL_DURATION, RENTAL_RATE, LENGTH, REPLACEMENT_COST, RATING, "
					+ "LAST_UPDATE, SPECIAL_FEATURES) VALUES (?, ?, ?, ?, ?, ?, ?, ?, 'R', NOW(), '{Trailers}')";

			PreparedStatement ps = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, title);
			ps.setInt(3, release_year);
			ps.setString(2, description);
			ps.setInt(4, language_id);
			ps.setInt(5, rental_duration);
			ps.setDouble(6, rental_rate);
			ps.setInt(7, length);
			ps.setDouble(8, replacement_cost);

			int affectedRows = ps.executeUpdate();

			if (affectedRows == 0) {
				throw new SQLException("Creating user failed, no rows affected.");
			}	
			else {
				try(ResultSet rs = ps.getGeneratedKeys()){
					if(rs.next()){
						var teste = rs.getInt("film_id");
						film.setFilm_id(teste);
						System.out.println("Filme inserido");
					}
					else{
						throw new SQLException("Creating film failed, no ID obtained.");
					}
				}
			}

		}
		catch(SQLException e) {
			e.printStackTrace();
		}		

		return film.getFilm_id();
	}

	public void delete(Integer film_id) {

		try {
			String sql = "DELETE FROM FILM WHERE film_id = ?";

			PreparedStatement ps = connect.prepareStatement(sql);

			ps.setInt(1, film_id);

			int affectedRows = ps.executeUpdate();

			if(affectedRows == 0) {
				throw new SQLException("Creating user failed, no rows affected.");
			}
			else {
				System.out.println("Filme Deletado!");
			}			
		}

		catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(Integer film_id, String title, String description, Integer release_year) {

		String sql = "UPDATE FILM SET TITLE = ?, DESCRIPTION = ?, RELEASE_YEAR = ? WHERE FILM_ID = ?";

		try {
			PreparedStatement ps = connect.prepareStatement(sql);

			ps.setInt(4, film_id);
			ps.setString(1, title);
			ps.setString(2, description);
			ps.setInt(3, release_year);

			int affectedRows = ps.executeUpdate();

			if(affectedRows == 0) {
				throw new SQLException("Creating user failed, no rows affected.");
			}
			else {
				System.out.println("Filme Atualizado!");
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}		

	}

	public String retrieve(Integer film_id) {

		String sql = "SELECT * FROM FILM WHERE FILM.FILM_ID = ?";

		try {
			PreparedStatement ps = connect.prepareStatement(sql);

			ps.setInt(1, film_id);

			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				film.setFilm_id(rs.getInt("film_id"));
				film.setTitle(rs.getString("title"));
				film.setDescription(rs.getString("description"));
				film.setRelease_year(rs.getInt("release_year"));
				film.setLanguage_id(rs.getInt("language_id"));
				film.setRental_duration(rs.getInt("rental_duration"));
				film.setRental_rate(rs.getDouble("rental_rate"));
				film.setLenght(rs.getInt("length"));
				film.setReplacement_cost(rs.getDouble("replacement_cost"));
				film.setRating(rs.getString("rating"));
				film.setLast_update(rs.getString("last_update"));
				film.setSpecial_features(rs.getString("special_features"));
				film.setFulltext(rs.getString("fulltext"));
			}


		} catch (SQLException e) {
			e.printStackTrace();
		}

		return film.toString();
	}


}	

