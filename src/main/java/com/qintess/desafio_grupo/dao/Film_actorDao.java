package com.qintess.desafio_grupo.dao;

import com.qintess.desafio_grupo.entities.Film_actor;
import org.postgresql.core.SqlCommand;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Film_actorDao {

    Dao connection = new Dao();
    Connection connect = connection.getConnection();
    Film_actor fa = new Film_actor();

    public String insert(Integer actor_id, Integer film_id){

        String sql = "INSERT INTO FILM_ACTOR(ACTOR_ID, FILM_ID) VALUES (?, ?)";

        try{
            PreparedStatement ps = connect.prepareStatement(sql);

            ps.setInt(1, actor_id);
            ps.setInt(2, film_id);

            int affectedRows = ps.executeUpdate();
            if(affectedRows == 0){
                throw new SQLException("Creating film_actor failed, no rows affected.");
            }
            else{
                System.out.println("Film_actor inserido!");
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return "Film_actor inserido!";
    }

    public String retrieve_actor(Integer actor_id){
        String sql = "SELECT * FROM FILM_ACTOR WHERE FILM_ACTOR.ACTOR_ID = ?";

        try{
            PreparedStatement ps = connect.prepareStatement(sql);

            ps.setInt(1, actor_id);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                fa.setActor_id(rs.getInt("actor_id"));
                fa.setFilm_id(rs.getInt("film_id"));
                fa.setLast_update(rs.getString("last_update"));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return fa.toString();
    }

    public String retrieve_film(Integer film_id){
        String sql = "SELECT * FROM FILM_ACTOR WHERE FILM_ACTOR.FILM_ID = ?";

        try{
            PreparedStatement ps = connect.prepareStatement(sql);

            ps.setInt(1, film_id);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                fa.setActor_id(rs.getInt("actor_id"));
                fa.setFilm_id(rs.getInt("film_id"));
                fa.setLast_update(rs.getString("last_update"));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return fa.toString();
    }

    public String delete_actor(Integer actor_id){
        String sql = "DELETE * FROM FILM_ACTOR WHERE FILM_ACTOR.ACTOR_ID = ?";

        try{
            PreparedStatement ps = connect.prepareStatement(sql);

            ps.setInt(1, actor_id);

            int affectedRows = ps.executeUpdate();
            if(affectedRows == 0){
                throw new SQLException("Deleting film_actor failed, no rows affected.");
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return "Film_actor deletado!";
    }

    public String delete_film(Integer film_id){
        String sql = "DELETE * FROM FILM_ACTOR WHERE FILM_ACTOR.ACTOR_ID = ?";

        try{
            PreparedStatement ps = connect.prepareStatement(sql);

            ps.setInt(1, film_id);

            int affectedRows = ps.executeUpdate();
            if(affectedRows == 0){
                throw new SQLException("Deleting film_actor failed, no rows affected.");
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return "Film_actor deletado!";
    }
}
