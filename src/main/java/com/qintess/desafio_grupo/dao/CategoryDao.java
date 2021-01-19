package com.qintess.desafio_grupo.dao;

import com.qintess.desafio_grupo.entities.Actor;
import com.qintess.desafio_grupo.entities.Category;

import java.sql.*;

public class CategoryDao {

    Dao connection = new Dao();
    Connection connect = connection.getConnection();

    Category category = new Category();

    public Integer insert(String name){

        String sql = "INSERT INTO CATEGORY(NAME, LAST_UPDATE) VALUES (?, NOW())";

        try {
            PreparedStatement ps = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, name);

            int affectedRows = ps.executeUpdate();
            if(affectedRows == 0){
                throw new SQLException("Creating category failed, no rows affected.");
            }
            else{
                try (ResultSet rs = ps.getGeneratedKeys()){
                    if(rs.next()){
                        category.setCategory_id(rs.getInt("category_id"));
                        System.out.println("Categoria Inserida!");
                    }
                    else{
                        throw new SQLException("Creating category failed, no ID obtained.");
                    }
                }
                catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }

        return category.getCategory_id();
    }

    public String retrieve(Integer category_id){

        String sql = "SELECT * FROM CATEGORY WHERE CATEGORY.CATEGORY_ID = ?";

        try{
            PreparedStatement ps = connect.prepareStatement(sql);

            ps.setInt(1, category_id);

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                category.setCategory_id(rs.getInt("category_id"));
                category.setName(rs.getString("name"));
                category.setLast_update(rs.getString("last_update"));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }

        return category.toString();
    }

    public void update (Integer category_id, String name){
        String sql = "UPDATE CATEGORY SET NAME = ? WHERE CATEGORY.CATEGORY_ID = ?";

        try{
            PreparedStatement ps = connect.prepareStatement(sql);

            ps.setInt(2, category_id);
            ps.setString(1, name);

            int affectedRows = ps.executeUpdate();
            if(affectedRows == 0){
                throw new SQLException("Updating category failed, no rows affected.");
            }
            else{
                System.out.println("Categoria atualizada!");
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void delete(Integer category_id){
        String sql = "DELETE FROM CATEGORY WHERE CATEGORY.CATEGORY_ID = ?";

        try{
            PreparedStatement ps = connect.prepareStatement(sql);

            ps.setInt(1, category_id);

            int affectedRows = ps.executeUpdate();
            if(affectedRows == 0){
                throw new SQLException("Deleting category failed, no rows affected.");
            }
            else{
                System.out.println("Usuário deletado!");
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
