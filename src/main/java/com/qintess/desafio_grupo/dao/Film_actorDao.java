package com.qintess.desafio_grupo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Film_actorDao {

    public void insert(Integer actor_id, Integer film_id){

        Dao connection = new Dao();
        Connection connect = connection.getConnection();

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
    }
}
