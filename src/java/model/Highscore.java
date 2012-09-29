/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import database.HighscoreController;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author mael
 */
public class Highscore {
    private Map hscore;
    private HighscoreController hsCont;

    public Highscore() {
        hsCont = new HighscoreController();
        hscore = hsCont.load();
    }
    
    public void add(String name, Integer score){
        System.out.println("Inserting data");
        
        if(hscore.containsKey(name)){
            if(score > (Integer)hscore.get(name)){
                hsCont.update(name, score);   
            }
        }else{
            hsCont.add(name, score);
        }
        hscore.put(name,score);


    }
    
    @Override
    public String toString(){
      String res = "";
        
      
      
      res = "Name | Score<br/><br/>";
        for (Iterator it = hscore.keySet().iterator(); it.hasNext();) {
            String key = (String) it.next();
            Integer val = (Integer) hscore.get(key);
            
            res += key + " | " + val + "<br/>";
        }
      
      return res;
    }
    
    public static void main(String args[]){
        Highscore hs = new Highscore();
        System.out.println(hs);
        
        hs.add("mael", 20);
        hs.add("mael", 40);
        

    }

    
}
