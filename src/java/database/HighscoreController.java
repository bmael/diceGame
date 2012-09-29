/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import javassist.bytecode.Descriptor;

/**
 *
 * @author mael
 */
public class HighscoreController {
    
    public void save(HashMap<String,Integer> hscore){
        Set keys = hscore.keySet();
        Iterator it = keys.iterator(); 
        while (it.hasNext()){
            String key= (String) it.next();
            Integer val = hscore.get(key);
            
            this.add(key, val);
            
        }
    }
    
    public HashMap<String,Integer> load(){
        HashMap hs = new HashMap<String, Integer>();
        
        try{
            Statement s = DataBaseManager.getInstance().con.createStatement();
            String sqlquery = "SELECT * FROM Highscore";
            ResultSet res = s.executeQuery(sqlquery);
            
            while(res.next()){
                hs.put(res.getString("name"), res.getInt("score"));
            }
            
        }catch(SQLException e){
            System.err.println("SQLException : error in selecting Highscore");
        }
        
        return hs;
    }
    
    public void add(String name, Integer score){
        try{
            Statement s = DataBaseManager.getInstance().con.createStatement();
                        
            String sqlquery = "INSERT INTO Highscore (name,score)"
                                + "VALUES('"+name+"', '"+ score +"')";
            s.executeUpdate(sqlquery);
            

        }catch(SQLException e){
            System.err.println("SQLException : error in adding Highscore");
            System.err.println(e);
        }
    }
    
    public void update(String name, Integer score){
        try{
            Statement s = DataBaseManager.getInstance().con.createStatement();
                        
            String sqlquery = "UPDATE Highscore SET score="+score+
                                " WHERE name='"+name+"'";
            s.executeUpdate(sqlquery);
            

        }catch(SQLException e){
            System.err.println("SQLException : error in updating "+name+" in Highscore");
            System.err.println(e);
        }
    }

}
