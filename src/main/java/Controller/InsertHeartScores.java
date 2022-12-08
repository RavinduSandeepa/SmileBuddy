/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ravin
 */
public class InsertHeartScores {

    public void insertScore(String username, int score) throws SQLException {

        DB_Connection obj = new DB_Connection();
        Connection connection = obj.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int id = 0,userscore = 0;
        boolean hasPreviousRecord = false;

        try {
            String query = "SELECT id,score FROM heart_scores WHERE username=?";
            ps = connection.prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if (rs.next()) {
                int numUsers = rs.getInt(1);
                if (numUsers > 0) {
                    hasPreviousRecord = true;
                    id = rs.getInt("id");
                    userscore = rs.getInt("score");
                    System.out.println("User :"+username+"'S Id is :"+id);
                    System.out.println("User :"+username+"'S Last Score is :"+userscore);
                } else {
                    hasPreviousRecord = false;
                }
            }

        } catch (Exception e) {
            System.out.println("Record catching error in Heart scores!");
        }
        if (hasPreviousRecord) {
            try {
                int tempHighScore = 0;
                if (score>=userscore) {
                    tempHighScore = score;
                }
                else{
                    tempHighScore = userscore;
                }
                String query = "UPDATE heart_scores SET score=?,lastScore=? WHERE id=?";
            
                ps = connection.prepareStatement(query);
                ps.setInt(1, tempHighScore);
                ps.setInt(2, score);
                ps.setInt(3, id);
                ps.executeUpdate();
                System.out.println("User :"+username+" Updated Successfully with score :"+score);
            } catch (Exception e) {
                System.out.println(" Error While Updating Heart Score Data!");
            }
            
            
        } else {

            try {
                String query = "INSERT INTO heart_scores(username,score,lastScore) VALUES(?,?,?)";

                ps = connection.prepareStatement(query);
                ps.setString(1, username);
                ps.setInt(2, score);
                ps.setInt(3,score);
                ps.executeUpdate();
                System.out.println("Scores inserted successfully into Heart DB");

            } catch (Exception e) {
                System.out.println("Some Error when Inserting Heart Scores to DB :");
                System.err.println(e);

            }
        }
        connection.close();
        ps.close();
    }
}
