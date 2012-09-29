/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author mael
 */
public class DataBaseManager {
    
    private static DataBaseManager instance;
    
    transient Connection con = null;
    
    private DataBaseManager(){
         try {
            Class.forName("com.mysql.jdbc.Driver");  //loads the driver
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/DiceGameData", "root", "root");
            
            //creates tables for the database
            createTableHighscore();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void createTableHighscore(){
        String sqlquery = "CREATE TABLE IF NOT EXISTS Highscore"+
                            "(id INT AUTO_INCREMENT,"
                            + "name VARCHAR(20),"
                            + "score INT,"
                            + "PRIMARY KEY(id));";
        try{
            Statement stmt = con.createStatement();
            stmt.executeUpdate(sqlquery);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public static synchronized DataBaseManager getInstance(){
        if(instance == null){
            instance = new DataBaseManager();
        }
        return instance;   
    }
    
    public static void main(String args[]){
        DataBaseManager.getInstance();
    }

}
