package com.qintess.desafio_grupo.dao;

import com.qintess.desafio_grupo.entities.Actor;

import java.sql.*;

public class ActorDao {

    Dao connection = new Dao();
    Connection connect = connection.getConnection();

    Actor actor = new Actor();

    public Integer insert(String first_name, String last_name){

        String sql = "INSERT INTO ACTOR(FIRST_NAME, LAST_NAME, LAST_UPDATE) VALUES (?, ?, NOW())";

        try{
            PreparedStatement ps = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, first_name);
            ps.setString(2, last_name);

            int affectedRows = ps.executeUpdate();

            if(affectedRows == 0){
                throw new SQLException("Creating actor failed, no rows affected.");
            }
            else{
                try(ResultSet rs = ps.getGeneratedKeys()){
                    if(rs.next()){
                        actor.setActor_id(rs.getInt("actor_id"));
                        System.out.println("Ator inserido!");
                    }
                    else{
                        throw new SQLException("Creating actor failed, no ID obtained.");
                    }
                }
                catch(SQLException e){
                    e.printStackTrace();
                }
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }

        return actor.getActor_id();
    }

    public String retrieve(Integer actor_id){

        String sql = "SELECT * FROM ACTOR WHERE ACTOR.ACTOR_ID = ?";

        try{
            PreparedStatement ps = connect.prepareStatement(sql);

            ps.setInt(1, actor_id);

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                actor.setActor_id(rs.getInt("actor_id"));
                actor.setFirst_name(rs.getString("first_name"));
                actor.setLast_name(rs.getString("last_name"));
                actor.setLast_update(rs.getString("last_update"));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }

        return actor.toString();
    }

    public void delete(Integer actor_id){

        String sql = "DELETE FROM ACTOR WHERE ACTOR.ACTOR_ID = ?";

        try{
            PreparedStatement ps = connect.prepareStatement(sql);

            ps.setInt(1, actor_id);

            int affectedRows = ps.executeUpdate();
            if(affectedRows == 0){
                throw new SQLException("Deleting actor failed, no rows affected.");
            }
            else{
               System.out.println("Ator Deletado!");
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void update(Integer actor_id, String last_name){

        String sql = "UPDATE ACTOR SET LAST_NAME = ? WHERE ACTOR.ACTOR_ID = ?";

        try {
            PreparedStatement ps = connect.prepareStatement(sql);

            ps.setInt(2, actor_id);
            ps.setString(1, last_name);

            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Updating actor failed, no rows affected.");
            } else {
                System.out.println("Ator atualizado!");
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
