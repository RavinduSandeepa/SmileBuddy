/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ravin
 */
public class DB_Connection {
    
    public Connection getConnection(){
    
        //connecting to the DB
        Connection connection = null;
        final String DB_URL = "jdbc:mysql://localhost:3308/mygame";
        final String USERNAME = "root";
        final String PASSWORD= "";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
		connection = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
                System.out.println("DB Connection is Ok");
        } catch (Exception e) {
            System.out.println("Some error when connection to DB with error :");
            System.out.println(e);
        }
        
        return connection;
    }
    
}
