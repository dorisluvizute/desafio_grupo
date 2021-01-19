package com.qintess.desafio_grupo.dao;

import com.qintess.desafio_grupo.entities.Film_category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Film_categoryDao {

    Dao connection = new Dao();
    Connection connect = connection.getConnection();
    Film_category fc = new Film_category();

    public String insert(Integer film_id, Integer category_id){
        String sql = "INSERT INTO FILM_CATEGORY(FILM_ID, CATEGORY_ID, LAST_UPDATE) VALUES (?, ?, NOW())";

        try{
            PreparedStatement ps = connect.prepareStatement(sql);

            ps.setInt(1, film_id);
            ps.setInt(2, category_id);

            int affectedRows = ps.executeUpdate();
            if(affectedRows == 0){
                throw new SQLException("Creating film_category failed, no rows affected.");
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return "Film_category inserido!";
    }

    public String retrieve_film(Integer film_id){
        String sql = "SELECT * FROM FILM_CATEGORY WHERE FILM_CATEGORY.FILM_ID = ?";

        try{
            PreparedStatement ps = connect.prepareStatement(sql);

            ps.setInt(1, film_id);

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                fc.setFilm_id(rs.getInt("film_id"));
                fc.setCategory_id(rs.getInt("category_id"));
                fc.setLast_update(rs.getString("last_update"));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }

        return fc.toString();
    }

    public String retrieve_category(Integer category_id){
        String sql = "SELECT * FROM FILM_CATEGORY WHERE FILM_CATEGORY.CATEGORY_ID = ?";

        try{
            PreparedStatement ps = connect.prepareStatement(sql);

            ps.setInt(1, category_id);

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                fc.setFilm_id(rs.getInt("film_id"));
                fc.setCategory_id(rs.getInt("category_id"));
                fc.setLast_update(rs.getString("last_update"));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }

        return fc.toString();
    }

    public String delete_film(Integer film_id){
        String sql = "DELETE * FROM FILM_CATEGORY WHERE FILM_CATEGORY.FILM_ID = ?";

        try{
            PreparedStatement ps = connect.prepareStatement(sql);

            ps.setInt(1, film_id);

            int affectedRows = ps.executeUpdate();
            if(affectedRows == 0){
                throw new SQLException("Deleting film_category failed, no rows affected.");
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return "Film_category deletado!";
    }

    public String delete_category(Integer category_id){
        String sql = "DELETE * FROM FILM_CATEGORY WHERE FILM_CATEGORY.CATEGORY_ID = ?";

        try{
            PreparedStatement ps = connect.prepareStatement(sql);

            ps.setInt(1, category_id);

            int affectedRows = ps.executeUpdate();
            if(affectedRows == 0){
                throw new SQLException("Deleting film_category failed, no rows affected.");
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return "Film_category deletado!";
    }
}
